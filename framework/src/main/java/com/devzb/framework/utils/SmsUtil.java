
package com.devzb.framework.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 短信工具类（http://sms.webchinese.cn/）
 * 
 * @author zhangbin
 *
 */
public class SmsUtil {

	private static Logger	logger		= LoggerFactory.getLogger(SmsUtil.class);
	private static String	username	= "sms_zhangbin";
	private static String	password	= "5c3e8b21467c08bad6ba";

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            多个手机号请用半角,隔开；如：13888888886,13888888887,1388888888
	 *            一次最多对100个手机发送
	 * @param content
	 *            内容
	 */
	public static void sendMessage(String mobile, String content) {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", username),
												new NameValuePair("Key", password),
												new NameValuePair("smsMob", mobile),
												new NameValuePair("smsText", content) };
		post.setRequestBody(data);

		String result = "";
		try {
			client.executeMethod(post);

			logger.info("短信发送状态: {}", post.getStatusCode());

			result = post.getResponseBodyAsString();
		} catch (HttpException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			post.releaseConnection();
		}

		logger.info("短信发送结果: {}", result);
	}

	public static void main(String[] args) throws Exception {
		sendMessage("13675853911", "当前锌价格为： 22800");
	}
}
