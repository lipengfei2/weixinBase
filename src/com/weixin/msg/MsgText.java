package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

/**
 * 文本消息
 * @author 牛司机
 * @version 2.0
 */
public class MsgText extends Msg {

	/**文本消息内容*/ 
	private String content;
	/**消息id，64位整型*/ 
	private String msgId;
	
	
	/**
	 * 默认构造
	 * 初始化head对象，主要由开发者调用
	 * */
	public MsgText() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_TEXT);// 设置消息类型
	}


	/**
	 * 此构造由程序内部接收微信服务器消息调用
	 * */
	public MsgText(HeadMsg head) {
		this.head = head;
	}

	
	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element contentElement = document.createElement(WeiXin.CONTENT);
		contentElement.setTextContent(this.content); 
		root.appendChild(contentElement); 
		document.appendChild(root);
	}

	
	@Override
	public void read(Document document) {
		this.content = document.getElementsByTagName(WeiXin.CONTENT).item(0).getTextContent();
		this.msgId = document.getElementsByTagName(WeiXin.MSG_ID).item(0).getTextContent();
	}
	
	
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
 

 
}
