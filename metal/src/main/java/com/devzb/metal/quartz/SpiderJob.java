
package com.devzb.metal.quartz;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.devzb.framework.enums.YesNo;
import com.devzb.framework.utils.DateUtil;
import com.devzb.framework.utils.SmsUtil;
import com.devzb.metal.dao.mapper.MetalMobileMapperExt;
import com.devzb.metal.dao.mapper.MetalSmsMapperExt;
import com.devzb.metal.dao.mapper.MetalZincPriceMapperExt;
import com.devzb.metal.dao.model.MetalMobile;
import com.devzb.metal.dao.model.MetalMobileExample;
import com.devzb.metal.dao.model.MetalSms;
import com.devzb.metal.dao.model.MetalSmsExample;
import com.devzb.metal.dao.model.MetalZincPrice;
import com.devzb.metal.dao.model.MetalZincPriceExample;
import com.devzb.metal.processor.ZincPageProcessor;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

/**
 * 爬虫任务
 * 
 * @author zhangbin
 *
 */
public class SpiderJob extends QuartzJobBean {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("SpiderJob Start.");

		// 爬虫抓取
		Spider spider = Spider.create(new ZincPageProcessor()).thread(1);
		String urlTemplate = "http://hq.smm.cn/xin";
		ResultItems resultItems = spider.<ResultItems> get(urlTemplate);
		String zincPrice = resultItems.get(ZincPageProcessor.ZINC_PRICE_KEY);
		spider.close();
		if (StringUtils.isNumeric(zincPrice)) {
			boolean isChange = false;
			long price = Long.valueOf(zincPrice) * 10000;
			logger.info("抓取到锌的价格： {}", price);

			MetalZincPriceMapperExt metalZincPriceMapperExt = (MetalZincPriceMapperExt) context.getMergedJobDataMap().get("metalZincPriceMapperExt");

			String dateDay = DateUtil.getDay();
			MetalZincPriceExample example = new MetalZincPriceExample();
			example.createCriteria().andDateDayEqualTo(dateDay);
			List<MetalZincPrice> metalZincPrices = metalZincPriceMapperExt.selectByExample(example);
			if (metalZincPrices.isEmpty()) {
				MetalZincPrice record = new MetalZincPrice();
				record.setDateDay(dateDay);
				record.setGmtCreated(new Date());
				record.setPrice(price);
				metalZincPriceMapperExt.insertSelective(record);
			} else {
				long oldPrice = metalZincPrices.get(0).getPrice();

				if (oldPrice != price) {
					isChange = true;
				}

				MetalZincPrice record = new MetalZincPrice();
				record.setId(metalZincPrices.get(0).getId());
				record.setPrice(price);
				record.setGmtModified(new Date());
				metalZincPriceMapperExt.updateByPrimaryKeySelective(record);
			}

			// 每天9点后才发送
			Date hour9 = DateUtil.getTimeForHour(9);
			if(hour9.before(new Date())){
				MetalSmsMapperExt metalSmsMapperExt = (MetalSmsMapperExt) context.getMergedJobDataMap().get("metalSmsMapperExt");
				MetalSmsExample metalSmsExample = new MetalSmsExample();
				metalSmsExample.createCriteria().andGmtCreatedGreaterThan(hour9);
				int num = metalSmsMapperExt.countByExample(metalSmsExample);
				if (num == 0 || isChange) {
					String mobile = "";

					// 查找需要发送短信的手机号
					MetalMobileMapperExt metalMobileMapperExt = (MetalMobileMapperExt) context.getMergedJobDataMap().get("metalMobileMapperExt");
					MetalMobileExample metalMobileExample = new MetalMobileExample();
					metalMobileExample.createCriteria().andIsSendEqualTo(YesNo.YES.value);
					List<MetalMobile> mobiles = metalMobileMapperExt.selectByExample(metalMobileExample);
					if (!mobiles.isEmpty()) {
						String[] tmps = new String[mobiles.size()];
						for (int i = 0; i < mobiles.size(); i++) {
							tmps[i] = mobiles.get(i).getMobile();
						}
						mobile = StringUtils.join(tmps, ",");
					}

					String content = dateDay + " 锌的价格为" + zincPrice + "元/吨。";
					// 判定是否有手机号
					if (StringUtils.isNotBlank(mobile)) {
						logger.info("发送短信 -> 手机号： {}, 内容： {}", mobile, content);

						SmsUtil.sendMessage(mobile, content);

						for (MetalMobile item : mobiles) {
							MetalSms record = new MetalSms();
							record.setContent(content);
							record.setGmtCreated(new Date());
							record.setMobile(item.getMobile());
							metalSmsMapperExt.insertSelective(record);
						}
					} else {
						logger.warn("无手机号需要发送短信, 内容为： {}", content);
					}
				} else {
					logger.warn("短信未发送（已经发送过或者价格未变动）");
				}
			} else {
				logger.warn("短信未发送（时间未到）");
			}
		}

		logger.info("SpiderJob End.");
	}

}
