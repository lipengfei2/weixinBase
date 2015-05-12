package com.weixin.req.data;

import com.weixin.http.HttpRequest;
import com.weixin.req.ReqAbstract;

public class ShortUrl extends ReqAbstract{
	
	private String URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
    private String action="long2short";
    private String method="POST";
    private String long_url;
    
	public ShortUrl() {
		super();
	}
	@Override
	public void doWeinxinReq() {
	    String res=	HttpRequest.connect(this);
	    System.out.println(res);
	}
    
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getLong_url() {
		return long_url;
	}
	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}

    public static void main(String[] args) {
    	ShortUrl su=new ShortUrl();
    	su.setLong_url("http://wap.koudaitong.com/v2/showcase/goods?alias=128wi9shh&spm=h56083&redirect_count=1");
    	su.doWeinxinReq();
	}

}
