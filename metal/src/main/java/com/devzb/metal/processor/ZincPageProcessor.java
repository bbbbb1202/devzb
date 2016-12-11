
package com.devzb.metal.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class ZincPageProcessor implements PageProcessor {
	
	private Logger			logger			= LoggerFactory.getLogger(getClass());
	
	public static String	ZINC_PRICE_KEY	= "zincPrice";
	
	private Site			site			= Site.me().setRetryTimes(3).setSleepTime(3000);

	@Override
	public void process(Page page) {
		String zincPrice = page.getHtml().xpath("//div[@class='first']/span[@class='value3']/text()").toString();

		logger.info("执行一次结果：{} ", zincPrice);

		page.putField(ZINC_PRICE_KEY, zincPrice);
		
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider spider = Spider.create(new ZincPageProcessor()).thread(2);
		String urlTemplate = "http://hq.smm.cn/xin";
		ResultItems resultItems = spider.<ResultItems> get(urlTemplate);
		System.out.println(resultItems);

		spider.close();
	}

}
