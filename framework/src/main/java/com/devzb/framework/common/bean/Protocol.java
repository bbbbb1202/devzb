
package com.devzb.framework.common.bean;

import com.alibaba.fastjson.JSON;
import com.devzb.framework.common.enums.ResponseCode;

/**
 * ajax统一返回结果
 * 
 * @author zhangbin
 *
 */
public class Protocol {
	private Integer	code	= ResponseCode.SUCCESS.code;
	private String	msg;
	private Object	data;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
