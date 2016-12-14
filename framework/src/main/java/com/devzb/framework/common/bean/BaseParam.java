package com.devzb.framework.common.bean;

/**
 * 基础参数类(v:版本号；t:时间戳)
 * 
 * @author zhangbin
 *
 */
public class BaseParam {

	private String	v;
	private Long	t;

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public Long getT() {
		return t;
	}

	public void setT(Long t) {
		this.t = t;
	}
}
