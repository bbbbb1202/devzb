
package com.devzb.framework.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具（基于jackson）
 * 
 * @author zhangb
 *
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
	public static final ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
		mapper.configure(Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
	}

	/**
	 * 
	 * JSON字符串转换为对象 JSON:"{\"type\":\"tom\"}"; resultSetClass:Metadata.class实体对象
	 */
	public static <E> E getJson2Entity(String json, Class<E> resultSetClass) {
		Object obj = null;
		try {
			if (json == null || "".equals(json)) {
				return null;
			}
			obj = mapper.readValue(json, resultSetClass);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (E) obj;
	}

	/**
	 * 
	 * JSON字符串转换为泛型list
	 * 
	 * 
	 * 
	 * @param <E>
	 */
	@SuppressWarnings("deprecation")
	public static <E> List<E> getJson2EntityList(String json,
			Class<?> collectionClass, Class<?>... elementClasses) {
		Object obj = null;
		try {
			if (json == null || "".equals(json)) {
				return null;
			}
			JavaType javaType = mapper.getTypeFactory()
					.constructParametricType(collectionClass, elementClasses);
			obj = mapper.readValue(json, javaType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<E>) obj;
	}

	/**
	 * 
	 * 对象转换为 JSON字符串 obj 实体对象
	 */
	public static <E> String getEntity2Json(Object obj) {
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
