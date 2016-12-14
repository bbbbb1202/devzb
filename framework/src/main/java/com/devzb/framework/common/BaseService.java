
package com.devzb.framework.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础service
 * 
 * @author zhangb
 *
 */
public abstract class BaseService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 打印debug日志
	 * 
	 * @param format
	 *            列子: 打印debug日志,id: {}, name: {}
	 * @param arguments
	 *            id,name
	 */
	protected void printDebugLog(String format, Object... arguments) {
		logger.debug(format, arguments);
	}

	/**
	 * 打印普通日志
	 * 
	 * @param format
	 *            列子: 打印普通日志,id: {}, name: {}
	 * @param arguments
	 *            id,name
	 */
	protected void printInfoLog(String format, Object... arguments) {
		logger.info(format, arguments);
	}

	/**
	 * 打印警告日志，该日志一定会打印
	 * 
	 * @param format
	 *            列子: 打印警告日志,id: {}, name: {}
	 * @param arguments
	 *            id,name
	 */
	protected void printWarnLog(String format, Object... arguments) {
		logger.warn(format, arguments);
	}

	/**
	 * 打印错误日志，该日志一定会打印
	 * 
	 * @param format
	 *            列子: 打印错误日志,id: {}, name: {}
	 * @param arguments
	 *            id,name
	 */
	protected void printErrorLog(String format, Object... arguments) {
		logger.error(format, arguments);
	}
}