package com.weixin.req.oauth;

import com.weixin.req.AppidSecret;
import com.weixin.req.ReqAbstract;

public class OauthFirst {

	/** 第一步请求发送到微信 */
	// private String appid;
	private AppidSecret appidSecret = new AppidSecret();
	private String redirect_uri;
	private final String response_type = "code";
	private String scope;
	private String state = "0";
	private String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	/** 第二步请求发送到微信 */
	public String getOauthUrl(String scope) {
		this.url.replace("APPID", this.appidSecret.getAppid())
				.replace("REDIRECT_URI", this.redirect_uri)
				.replace("SCOPE", this.scope).replace("STATE", this.state);
		return this.url;
	}

	public AppidSecret getAppidSecret() {
		return appidSecret;
	}

	public void setAppidSecret(AppidSecret appidSecret) {
		this.appidSecret = appidSecret;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponse_type() {
		return response_type;
	}

	public static void main(String[] args) {
		System.out.println("qqq".replace("q", "sdd"));
	}

}
