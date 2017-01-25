
package com.devzb.framework.lang.config;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * 自己定义的CsrfMatcher，参考了DefaultRequiresCsrfMatcher，并新增了排除功能
 * 
 * @author zhangbin
 *
 */
public class DevzbCsrfMatcher implements RequestMatcher {
	/**
	 * 例外的url
	 */
	private List<String>	exclusions;
	private final Pattern	allowedMethods	= Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	@Override
	public boolean matches(HttpServletRequest request) {
		if (allowedMethods.matcher(request.getMethod()).matches()) {// 非ajax请求直接返回false
			return false;
		}

		String path = request.getServletPath();
		if (exclusions.contains(path)) {
			return false;
		}

		return true;
	}

	public void setExclusions(List<String> exclusions) {
		this.exclusions = exclusions;
	}

}
