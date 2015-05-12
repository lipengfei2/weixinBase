package com.weixin.req;

public class AppidSecret {

	private String appid = "wxb1aae900c2c03589";
	private String secret = "14c779b1d7d7080772bd48c60465ce08";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public static void main(String[] args) {
		System.out.println(new AppidSecret().getAppid() == new AppidSecret()
				.getAppid());
	}
}
