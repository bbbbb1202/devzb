
package com.devzb.framework.lang.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class DevzbMultipartResolver extends CommonsMultipartResolver {

	private Logger			logger	= LoggerFactory.getLogger(getClass());
	private List<String>	exclusions;

	@Override
	public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {

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
}
