package com.weixin.media;

import com.weixin.http.HttpRequest;
import com.weixin.req.MediaAbstract;
import com.weixin.req.ReqAbstract;

public class Media extends MediaAbstract {

	private String type;
	private String URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private String media;
	private String method;
	
	
	private String media_id;
    private String created_at;
    
    
   
    
    
    
	public  void doWeinxinReq() {
		
		HttpRequest.uploadMedia(this);
		
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getURL() {
		URL=this.URL.replace("TYPE", this.type);
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}




	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
	
public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
public static void main(String[] args) {
	Media m=new Media();
	m.setType("image");
	HttpRequest.uploadMedia(m);
	//m.upload();
}
}
