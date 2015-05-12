package com.weixin.req.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.req.id.ServiceIp;
import com.weixin.util.JsonUtil;

public class UserSummary extends ReqAbstract {
	private String URL = "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
	private String method = "POST";
	private String begin_date;
	private String end_date;
	private List<DataDay> list;

	@Override
	public void doWeinxinReq() {
		String res = HttpRequest.connect(this);
		Map classMap=new HashMap<String, Class>();
		classMap.put("list", DataDay.class);
		UserSummary us = (UserSummary) JsonUtil.getObjectFromJsonStr(res,
				UserSummary.class);
		this.setList(us.getList());
	}



	public List<DataDay> getList() {
		return list;
	}



	public String getURL() {
		return URL;
	}



	public void setURL(String uRL) {
		URL = uRL;
	}







	public void setList(List<DataDay> list) {
		this.list = list;
	}



	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public static void main(String[] args) {
		UserSummary userSummary=new UserSummary();
		userSummary.setBegin_date("2015-04-05");
		userSummary.setEnd_date("2015-04-11");
		userSummary.doWeinxinReq();
	}

}
