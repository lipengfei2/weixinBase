package com.weixin.req;

import java.util.Map;
import net.sf.json.JSONObject;
import com.weixin.http.HttpRequest;

public class AccessToken {

	/***/
	private AppidSecret appidSecret = new AppidSecret();
	private String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
	private String grant_type = "client_credential";
	private String access_taken;

	public String getAccess_taken() {
		String res = HttpRequest.connect(
				url.replace("APPID", appidSecret.getAppid()).replace("SECRET",
						appidSecret.getSecret()), null, "GET");
		Map map = JSONObject.fromObject(res);
		this.setAccess_taken((String) map.get("access_token"));
		return access_taken;
	}

	public void setAccess_taken(String access_taken) {
		this.access_taken = access_taken;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AppidSecret getAppidSecret() {
		return appidSecret;
	}

	public void setAppidSecret(AppidSecret appidSecret) {
		this.appidSecret = appidSecret;
	}

	public static void main(String[] args) {
		System.out
				.println(new AccessToken().getAppidSecret() == new AccessToken()
						.getAppidSecret());
	}
}
