package com.weixin.msg;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.Session;
import com.weixin.WeiXin;


/**
 * @author 牛司机
 * @version 2.0
 * 消息头，所有的消息都有一个相同的消息头，包含开发者公众号appdid、发送者账号OpenID、时间、消息类型
 * */
public  class HeadMsg {

	    /**开发者微信号*/ 
		private String toUserName;
	    /**发送方帐号（一个OpenID）*/
		private String fromUserName;
	    /**消息创建时间 （整型）*/
		private String createTime;
	    /**消息类型*/
		private String msgType;
		
		
	//	private HttpServletRequest request;
	    
		
		/**
		 * 一般由程序内部调用，开发者不用调用
		 * */
		public HeadMsg() { 
			this.createTime = new Date().getTime()+"";//初始化创建时间
		}

		public void write(Element root, Document document) {
			Element toUserNameElement = document
					.createElement(WeiXin.TO_USER_NAME);
			toUserNameElement.setTextContent(this.toUserName);
			Element fromUserNameElement = document
					.createElement(WeiXin.FROM_USER_NAME);
			fromUserNameElement.setTextContent(this.fromUserName);
			Element createTimeElement = document
					.createElement(WeiXin.CREATE_TIME);
			createTimeElement.setTextContent(this.createTime);
			Element msgTypeElement = document
					.createElement(WeiXin.MSG_TYPE);
			msgTypeElement.setTextContent(this.msgType);

			root.appendChild(toUserNameElement);
			root.appendChild(fromUserNameElement);
			root.appendChild(createTimeElement);
			root.appendChild(msgTypeElement);
		}

		public void read(Document document) {
			this.toUserName = document
					.getElementsByTagName(WeiXin.TO_USER_NAME).item(0)
					.getTextContent();
			this.fromUserName = document
					.getElementsByTagName(WeiXin.FROM_USER_NAME).item(0)
					.getTextContent();
			this.createTime = document
					.getElementsByTagName(WeiXin.CREATE_TIME).item(0)
					.getTextContent();
			this.msgType = document.getElementsByTagName(WeiXin.MSG_TYPE)
					.item(0).getTextContent();
			
		}

		public String getToUserName() {
			return toUserName;
		}

		public void setToUserName(String toUserName) {
			this.toUserName = toUserName;
		}

		public String getFromUserName() {
			return fromUserName;
		}

		public void setFromUserName(String fromUserName) {
			this.fromUserName = fromUserName;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getMsgType() {
			return msgType;
		}

		public void setMsgType(String msgType) {
			this.msgType = msgType;
		}

		/*public HttpServletRequest getRequest() {
			return request;
		}

		public void setRequest(HttpServletRequest request) {
			this.request = request;
		}*/

}
