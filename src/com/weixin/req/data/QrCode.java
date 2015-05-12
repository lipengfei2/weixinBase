package com.weixin.req.data;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.util.JsonUtil;

public class QrCode extends ReqAbstract {

	private final static String QR_SCENE = "QR_SCENE";
	private final static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
	private final static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";

	private String URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	private String expire_seconds;
	private String action_name;
	private ActionInfo action_info;
	private String method = "POST";
	private String ticket;
	private String url;

	@Override
	public void doWeinxinReq() {
		String res = HttpRequest.connect(this);
		System.out.println(res);
		Map classMap=new HashMap<String, Class>();
		classMap.put("action_info", ActionInfo.class);
		classMap.put("scene", Scene.class);
		QrCode us = (QrCode) JsonUtil.getObjectFromJsonStr(res,
				QrCode.class);
		this.setTicket(us.getTicket());
		this.setUrl(us.getUrl());
	}


	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public ActionInfo getAction_info() {
		return action_info;
	}

	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public static void main(String[] args) {
		QrCode q=new QrCode();
		q.setAction_name(QrCode.QR_LIMIT_SCENE);
		ActionInfo ac=new ActionInfo();
		Scene s=new Scene();
		s.setScene_str("dnsoggk");
		ac.setScene(s);
		q.setAction_info(ac);
		q.doWeinxinReq();
	}

}
