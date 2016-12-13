
package com.devzb.framework.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import com.devzb.framework.bean.Protocol;

/**
 * .xml请求的返回结果
 * 
 * @author zhangbin
 *
 */
public class FinderXmlView extends MappingJackson2XmlView {
	private String	key	= Protocol.class.getSimpleName().toLowerCase();

	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object value = model.get(key);
		if (value != null && value instanceof Protocol) {
			Protocol protocol = (Protocol) value;
			root result = new root();
			if (protocol.getCode() != null) {
				result.put("code", protocol.getCode()+"");
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

/**
 * xml最外层（类名故意写成小写）
 * 
 * @author zhangbin
 *
 */
class root extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
}
