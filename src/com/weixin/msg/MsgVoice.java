package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

/**
 * @author marker
 * @date 2013-11-8 上午9:33:46
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
public class MsgVoice extends Msg{

	// 语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
	private String mediaId;
	// 语音格式：amr
	private String format;
	// 语音识别结果，UTF8编码
	private String recognition;
	// 消息id，64位整型
	private String msgId;
	
	
	/**
	 * 默认构造
	 */
	public MsgVoice() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_VOICE);
	}
	
	
	public MsgVoice(HeadMsg head){
		this.head = head;
	}
	
	
	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element voiceElement = document.createElement(WeiXin.VOICE);
		Element mediaIdElement = document.createElement(WeiXin.MEDIAID);
		voiceElement.appendChild(mediaIdElement);
		root.appendChild(voiceElement); 
		document.appendChild(root); 
	}

	
	@Override
	public void read(Document document) {
		this.mediaId = getElementContent(document, WeiXin.MEDIAID);
		this.format = getElementContent(document, WeiXin.FORMAT);
		this.recognition = getElementContent(document, WeiXin.RECOGNITION);
		this.msgId = getElementContent(document, WeiXin.MSG_ID);
	}


	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}


	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}


	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}


	/**
	 * @return the recognition
	 */
	public String getRecognition() {
		return recognition;
	}


	/**
	 * @param recognition the recognition to set
	 */
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}


	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}


	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	
	
	
	
	
	
}
