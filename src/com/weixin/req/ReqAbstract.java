package com.weixin.req;

import java.util.Map;

import com.weixin.util.JsonUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

public abstract class ReqAbstract {

	protected AccessToken accessToken = new AccessToken();
	private String errcode;
	private String errmsg;

	public void doWeinxinReq() {
	}

	public String getURL() {
		return null;
	}

	public String getMethod() {
		return null;
	}

	public String getParams() {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);// 保证不会死循环
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("accessToken")) {
					return true;
				}
				if (name.equals("errcode")) {
					return true;
				}
				if (name.equals("method")) {
					return true;
				}
				if (name.equals("URL")) {
					return true;
				}
				if (name.equals("params")) {
					return true;
				}
				return value == null;
			}
		});
		JSONObject json = JSONObject.fromObject(this, jsonConfig);
		return json.toString();
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public String getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

}
