package com.weixin.req.js_sdk;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.weixin.MySecurity;
import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.util.JsonUtil;

/*** 这个方法最好在过滤器中进行设置 */
public class JsapiTicket extends ReqAbstract {

	private String ticket;
	private String expires_in;
	private String URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	private String method = "GET";
	private String nonceStr;
	private String signature;// 签名

	public void doWeinxinReq() {
		String res = HttpRequest.connect(this);
		JsapiTicket jsapiTicket = (JsapiTicket) JsonUtil.getObjectFromJsonStr(
				res, JsapiTicket.class);
		this.ticket = jsapiTicket.getTicket();
		this.expires_in = jsapiTicket.getExpires_in();
	}

	public JsapiTicket getJsapiTicket(HttpServletRequest request) {
		String string1 = "jsapi_ticket="
				+ this.getTicket()
				+ "&noncestr"
				+ nonceStr
				+ "&timestamp="
				+ (new Date().getTime() + "&url="
						+ request.getRequestURL().toString() + (request
						.getQueryString() == null ? "" : ("?" + request
						.getQueryString())));
		this.signature = new MySecurity().encode(string1, MySecurity.SHA_1);
		return this;
	}

	public String getTicket() {
		// 实现获得ticket的逻辑
		doWeinxinReq();
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

}
