package com.weixin.msg;

import org.w3c.dom.Document;

import com.weixin.WeiXin;

/**
 * 链接消息
 * @author 牛司机
 * @version 2.0
 * */
public class MsgLink extends Msg {

	//消息标题
	private String title;	 
	//消息描述
	private String description;	 
	//消息链接
	private String url;	 
	//消息id，64位整型
	private String msgId;
	
	/**
	 * 开发者调用创建实例
	 * */
	public MsgLink() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_LINK);
	}
	
	/**
	 * 推送来的消息采用此构造
	 * @param head
	 */
	public MsgLink(HeadMsg head) {
		this.head = head; 
	}

	@Override
	public void write(Document document) { }
	
	@Override
	public void read(Document document) {
		this.title = document.getElementsByTagName(WeiXin.TITLE).item(0).getTextContent();
		this.description = document.getElementsByTagName(WeiXin.DESCRITION).item(0).getTextContent();
		this.url = document.getElementsByTagName(WeiXin.URL).item(0).getTextContent();
		this.msgId = document.getElementsByTagName(WeiXin.MSG_ID).item(0).getTextContent();
	} 
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
