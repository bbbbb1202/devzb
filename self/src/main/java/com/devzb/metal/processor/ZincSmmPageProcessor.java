
package com.devzb.metal.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 金属锌爬虫处理器(http://hq.smm.cn)
 * 
 * @author zhangbin
 *
 */
public class ZincSmmPageProcessor implements PageProcessor {

	private Logger			logger			= LoggerFactory.getLogger(getClass());

	public static String	ZINC_PRICE_KEY	= "zincPrice";

	private Site			site			= Site.me().setRetryTimes(3).setSleepTime(3000);

	@Override
	public void process(Page page) {
		String zincPrice = page.getHtml().xpath("//li[@product_id='zn0000']/span[@class='fvalue2']/text()").toString();

		logger.info("执行一次结果：{} ", zincPrice);

		page.putField(ZINC_PRICE_KEY, zincPrice);

	}

	@Override
	public Site getSite() {
		return site;
	}

	/**
	 * 通过爬虫获取锌的价格
	 * 
	 * @return
	 */
	public static String getZincPriceBySpider() {
		// 爬虫抓取
		Spider spider = Spider.create(new ZincSmmPageProcessor()).thread(1);
		String urlTemplate = "https://hq.smm.cn/xin";
		ResultItems resultItems = spider.<ResultItems> get(urlTemplate);
		String zincPrice = resultItems.get(ZincSmmPageProcessor.ZINC_PRICE_KEY);
		spider.close();

		return zincPrice;
	}
}
