package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

public class MsgTransferCustomerService extends Msg {

	/** 文本消息内容 */
	private String content;
	/** 消息id，64位整型 */
	private String msgId;
	/** 指定会话接入的客服账号  */
	private String KfAccount;

	public MsgTransferCustomerService(HeadMsg head) {
		this.head = head;
	}

	public MsgTransferCustomerService() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_TRANSFER_CUSTOMER_SERVICE);// 设置消息类型
	}

	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element TransInfoElement = document.createElement(WeiXin.TRANSINFO);
		Element KfAccountElement = document.createElement(WeiXin.KFACCOUNT);
		KfAccountElement.setTextContent(this.KfAccount); 
		TransInfoElement.appendChild(KfAccountElement);
		root.appendChild(TransInfoElement); 
		document.appendChild(root);

	}

	@Override
	public void read(Document document) {

	}

}
