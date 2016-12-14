
package com.devzb.framework.lang.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.devzb.framework.common.bean.Protocol;

/**
 * .json请求的返回结果
 * 
 * @author zhangbin
 *
 */
public class FinderJsonView extends MappingJackson2JsonView {
	private String key = Protocol.class.getSimpleName().toLowerCase();

	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object value = model.get(key);
		if (value != null && value instanceof Protocol) {
			Protocol protocol = (Protocol) value;
			Map<String, Object> result = new HashMap<String, Object>(2);
			if (protocol.getCode() != null) {
				result.put("code", protocol.getCode());
			}
			if (protocol.getData() != null) {
				result.put("data", protocol.getData());
			}
			if (protocol.getMsg() != null) {
				result.put("msg", protocol.getMsg());
			}
			return result;
		}
		return null;
	}
}
