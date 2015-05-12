package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

/**
 * 视频消息
 * @author marker
 * @date 2013-8-25 上午8:54:03
 * @version 1.0
 * @blog www.yl-blog.com
 * @weibo http://t.qq.com/wuweiit
 */
public class MsgVideo extends Msg{
	// 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String mediaId;
	// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	private String thumbMediaId;
	// 消息id，64位整型
	private String msgId;
 
	
	/**
	 * 开发者调用
	 * */
	public MsgVideo() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_VIDEO);
	}
	
	
	
	/**
	 * @param head
	 */
	public MsgVideo(HeadMsg head) {
		this.head = head;
	}



	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element videoElement = document.createElement(WeiXin.VIDEO);
		Element mediaIdElement = document.createElement(WeiXin.MEDIAID);
		Element thumbMediaIdElement = document.createElement(WeiXin.THUMBMEDIAID);
		videoElement.appendChild(mediaIdElement);
		videoElement.appendChild(thumbMediaIdElement);
		root.appendChild(videoElement); 
		document.appendChild(root);
	}
	
	
	// 因为用户不能发送音乐消息给我们，因此没有实现
	@Override
	public void read(Document document) {
		this.mediaId = getElementContent(document, WeiXin.MEDIAID);
		this.thumbMediaId = getElementContent(document, WeiXin.THUMBMEDIAID);
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
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}



	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
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