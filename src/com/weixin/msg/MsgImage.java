package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;
/**
 * 图片消息
 * @author 牛司机
 * @version 2.0
 */
public class MsgImage extends Msg{

	/**图片链接*/ 
	private String picUrl;
	/**消息id，64位整型*/  
	private String msgId; 
	/**图片消息媒体id*/  
	private String mediaId;
	
	
	/**
	 * 开发者调用
	 * */
	public MsgImage() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_IMAGE);
	}

	public MsgImage(HeadMsg head) {
		this.head = head;
	}
	
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		this.head.write(root, document);
		Element imageElement = document.createElement(WeiXin.IMAGE); 
		Element mediaIdElement = document.createElement(WeiXin.MEDIAID);
		imageElement.appendChild(mediaIdElement);
		root.appendChild(imageElement);
		document.appendChild(root);
	}
	
	
	public void read(Document document) {
		this.picUrl = document.getElementsByTagName(WeiXin.PIC_URL).item(0).getTextContent();
		this.mediaId = getElementContent(document, WeiXin.MEDIAID);
		this.msgId   = document.getElementsByTagName(WeiXin.MSG_ID).item(0).getTextContent();
	}


	public String getPicUrl() {
		return picUrl;
	}


	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	public String getMsgId() {
		return msgId;
	}


	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	
	
}
