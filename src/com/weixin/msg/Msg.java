package com.weixin.msg;

import org.w3c.dom.Document;

/**
 * @author 牛司机
 * @version 2.0
 * 所有消息类都要继承的抽象类
 * */
public abstract  class  Msg {
	
	/** 消息头 */
	protected HeadMsg head;
	
	/**
	 * 写入消息内容
	 * @param document
	 */
	public abstract void write(Document document);

	
	/**
	 * 读取消息内容
	 * @param document
	 */
	public abstract void read(Document document);

	
	
	/**
	 * 获取节点文本内容
	 * @param document 文档
	 * @param element 节点名称
	 * @return 内容
	 */
	protected String getElementContent(Document document, String element){
		if(document.getElementsByTagName(element).getLength() > 0){// 判断是否有节点 
			return document.getElementsByTagName(element).item(0).getTextContent();
		}else{
			return null;
		}
	}
	
	
	
	public HeadMsg getHead() {
		return head;
	}

	public void setHead(HeadMsg head) {
		this.head = head;
	}

	public String getToUserName() {
		return head.getToUserName();
	}
	
	public void setToUserName(String toUserName) {
		head.setToUserName(toUserName);
	}

	public String getFromUserName() {
		return head.getFromUserName();
	}

	public void setFromUserName(String fromUserName) {
		head.setFromUserName(fromUserName);
	}
	
	public String getCreateTime() {
		return head.getCreateTime();
	}

	public void setCreateTime(String createTime) {
		head.setCreateTime(createTime);
	}
	
}
