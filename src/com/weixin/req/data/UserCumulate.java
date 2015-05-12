package com.weixin.req.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;
import com.weixin.util.JsonUtil;

public class UserCumulate extends ReqAbstract {
	private String URL = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
	private String method = "POST";
	private String begin_date;
	private String end_date;
	private List<DataDay> list;
	@Override
	public void doWeinxinReq() {
		String res = HttpRequest.connect(this);
		Map classMap=new HashMap<String, Class>();
		classMap.put("list", DataDay.class);
		UserCumulate us = (UserCumulate) JsonUtil.getObjectFromJsonStr(res,
				UserCumulate.class);
		this.setList(us.getList());
		
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
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
	public List<DataDay> getList() {
		return list;
	}
	public void setList(List<DataDay> list) {
		this.list = list;
	}


}
