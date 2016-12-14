
package com.devzb.framework.utils;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具（基于jackson），注：spring大部分基于jackson，手动处理时尽量使用该工具进行json数据转换
 * 
 * @author zhangb
 *
 */
@SuppressWarnings("unchecked")
public class JsonUtil {
	private static Logger				logger	= LoggerFactory.getLogger(JsonUtil.class);
	public static final ObjectMapper	mapper	= new ObjectMapper();

	static {
		mapper.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
		mapper.configure(Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
		mapper.setSerializationInclusion(Include.NON_NULL);// null不参与序列化
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
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
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
	public static <E> List<E> getJson2EntityList(String json, Class<?> collectionClass, Class<?>... elementClasses) {
		Object obj = null;
		try {
			if (json == null || "".equals(json)) {
				return null;
			}
			@SuppressWarnings("deprecation")
			JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
			obj = mapper.readValue(json, javaType);
		} catch (JsonParseException e) {
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			logger.error("Json Object Generat Fail: {} ", e.getMessage());
			// e.printStackTrace();
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
