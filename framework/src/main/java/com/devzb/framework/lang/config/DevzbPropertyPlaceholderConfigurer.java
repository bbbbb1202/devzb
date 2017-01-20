
package com.devzb.framework.lang.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * spring载入配置文件封装
 * 
 * @author zhangbin
 *
 */
public class DevzbPropertyPlaceholderConfigurer
										extends PropertyPlaceholderConfigurer {

	public DevzbPropertyPlaceholderConfigurer() {
		setIgnoreResourceNotFound(true);
		setIgnoreUnresolvablePlaceholders(false);
		setFileEncoding("UTF-8");
	}

	@Override
	public void setLocations(Resource... locations) {
		super.setLocations(locations);
	}
}
