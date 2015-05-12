package com.weixin.req.id;

import java.util.List;
import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.util.JsonUtil;

public class ServiceIp extends ReqAbstract {

	private String URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	private List<String> ip_list;
	private String method = "GET";

	@Override
	public void doWeinxinReq() {
		String res = HttpRequest.connect(this);
		ServiceIp ip = (ServiceIp) JsonUtil.getObjectFromJsonStr(res,
				ServiceIp.class);
		this.setIp_list(ip.getIp_list());
	}

	public List<String> getIp_list() {
		return ip_list;
	}

	public void setIp_list(List<String> ip_list) {
		this.ip_list = ip_list;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public static void main(String[] args) {
		ServiceIp ip = new ServiceIp();
		ip.doWeinxinReq();
	}

}
