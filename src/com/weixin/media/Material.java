package com.weixin.media;

import java.util.List;

import com.weixin.http.HttpRequest;
import com.weixin.req.MediaAbstract;
import com.weixin.req.ReqAbstract;

public class Material extends MediaAbstract {

	private String type;
	private String URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private String media;
	private String method="POST";

	private String media_id;
	private String created_at;

	
	private List<Article> articles;
	
	private String title;
	private String  introduction;
	
	
	
	
	
	

	public void upload() {
		URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
		
		
	}

	public void get() {
		URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	}

	public void addNews() {
		URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

	}
	public void getMaterial(){
		URL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
		HttpRequest.uploadMedia(this);
		
		
	}

	
	
	


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getURL() {
		this.URL=this.URL.replace("TYPE", this.type);
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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	public static void main(String[] args) {
		Material m=new Material();
		//https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN
		m.setURL("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN");
		m.setMedia_id("2tCuULM5J6SoDZZQzmv_bE2nRQlzFqxsUz41xGKF6JlzBGJwqVQl4MKcaSw1Y-oM");
		HttpRequest.downloadMedia(m);
	}
	
	
	
	
	
}
