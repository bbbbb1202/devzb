
package com.devzb.framework.lang.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 判定是否是Multipart请求以及设置staticHost
 * 
 * @author zhangbin
 *
 */
public class DevzbMultipartResolver extends CommonsMultipartResolver {

	private Logger			logger		= LoggerFactory.getLogger(getClass());
	/**
	 * 需要排除的url
	 */
	private List<String>	exclusions;
	/**
	 * 静态文件服务器地址
	 */
	private String			staticHost	= "//static.devzb.com";

	@Override
	public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {
		request.setAttribute("staticHost", staticHost);

		String path = request.getServletPath();
		if ("/favicon.ico".equals(path) || path.indexOf("/resources") == 0) {// 静态文件直接跳过
			return false;
		}

		logger.info(path);

		if (exclusions.contains(path)) {
			return false;
		}

		return super.isMultipart(request);
	}

	public void setExclusions(List<String> exclusions) {
		logger.info("MultipartResolver exclusions url: {}", exclusions.toString());
		this.exclusions = exclusions;
	}

	public void setStaticHost(String staticHost) {
		logger.info("MultipartResolver staticHost: {}", staticHost);
		this.staticHost = staticHost;
	}

}
