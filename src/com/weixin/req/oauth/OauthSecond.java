package com.weixin.req.oauth;

import java.util.Map;

import com.weixin.http.HttpRequest;
import com.weixin.req.AppidSecret;
import com.weixin.req.ReqAbstract;
import com.weixin.req.id.ServiceIp;
import com.weixin.util.JsonUtil;

public class OauthSecond{
	
	private AppidSecret appidSecret = new AppidSecret();
    private String code;
    private final String grant_type="authorization_code";
    private String URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    private String method="GET";
    
    
    private String  access_token;
    private String  expires_in;
    private String  refresh_token;
    private String  openid;
    private String  scope;
    private String  unionid;
    
	public void doWeinxinReq() {
		String res=HttpRequest.connect(URL.replace("APPID", appidSecret.getAppid()).replace("SECRET", appidSecret.getSecret()).replace("APPID", appidSecret.getAppid()), null, method);
		OauthSecond os=(OauthSecond) JsonUtil.getObjectFromJsonStr(res, OauthSecond.class);
		this.setAccess_token(os.getAccess_token());
		this.setExpires_in(os.getExpires_in());
		this.setRefresh_token(os.getRefresh_token());
		this.setOpenid(os.getOpenid());
		this.setScope(os.getScope());
		this.setUnionid(os.getUnionid());
	}

	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public AppidSecret getAppidSecret() {
		return appidSecret;
	}

	public void setAppidSecret(AppidSecret appidSecret) {
		this.appidSecret = appidSecret;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}



	
}
