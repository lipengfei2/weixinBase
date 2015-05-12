package com.weixin.req.customservice;

import java.util.List;

import com.weixin.http.HttpRequest;
import com.weixin.msg.MsgTransferCustomerService;
import com.weixin.req.MediaAbstract;
import com.weixin.req.ReqAbstract;

public class CustomService extends MediaAbstract {
	/**账户id*/
	private String kf_id;
	/**账户名称*/
	private String kf_account;
    /**账户昵称*/
	private String kf_nick;
	/**账户昵称*/
	private String nickname;
    private String kf_headimgurl;
	private String password;

	
	
	private String URL;
	private String method = "POST";
	
	

	private String media;
	private List<CustomService>  kf_list;
	
	
	
	private String touser;
	private String msgtype;
	
	private List<MsgImage>  image;
	
    public void add(){
    	this.URL="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
    	HttpRequest.connect(this);
    }
    public void update(){
    	this.URL="https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
    	HttpRequest.connect(this);
    }
    public void del(){
    	this.URL="https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
    	HttpRequest.connect(this);
    }
    public void uploadheadimg(){
    	this.URL="https:// api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
    	HttpRequest.uploadMedia(this);
    }
	
	
	
	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getKf_id() {
		return kf_id;
	}
	public void setKf_id(String kf_id) {
		this.kf_id = kf_id;
	}
	public String getKf_nick() {
		return kf_nick;
	}
	public void setKf_nick(String kf_nick) {
		this.kf_nick = kf_nick;
	}
	public String getKf_headimgurl() {
		return kf_headimgurl;
	}
	public void setKf_headimgurl(String kf_headimgurl) {
		this.kf_headimgurl = kf_headimgurl;
	}
	public List<CustomService> getKf_list() {
		return kf_list;
	}
	public void setKf_list(List<CustomService> kf_list) {
		this.kf_list = kf_list;
	}
	public static void main(String[] args) {
		
	}

}
