package com.weixin.req.template;

import com.weixin.req.ReqAbstract;

public class Template<T> extends ReqAbstract {
	private String touser;
	private String template_id;
	private String url;
	private String topcolor;
	private T data;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopcolor() {
		return topcolor;
	}

	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/*
	 * "touser":"OPENID",
	 * "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
	 * "url":"http://weixin.qq.com/download", "topcolor":"#FF0000", "data":{
	 */

}
