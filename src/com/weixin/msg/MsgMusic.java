package com.weixin.msg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

/**
 * 音乐消息(只能回复)
 * @author 牛司机
 * @version 2.0
 */
public class MsgMusic extends Msg{
	/**标题*/ 
	private String title;
	/**描述*/ 
	private String description;
	/**音乐链接*/ 
	private String musicUrl;
	/**高质量音乐链接，WIFI环境优先使用该链接播放音乐*/ 
	private String hQMusicUrl;
	/**缩略图的媒体id，通过上传多媒体文件，得到的id*/ 
	private String thumbMediaId;
	
	
	/**
	 * 开发者调用
	 * */
	public MsgMusic() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_MUSIC);
	}
	
	
	
	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element musicElement = document.createElement(WeiXin.MUSIC); 
		Element titleElement = document.createElement(WeiXin.TITLE);
		titleElement.setTextContent(this.title);
		Element descriptionElement = document.createElement(WeiXin.DESCRITION);
		descriptionElement.setTextContent(this.description);
		Element musicUrlElement = document.createElement(WeiXin.MUSIC_URL);
		musicUrlElement.setTextContent(this.musicUrl);
		Element hQMusicUrlElement = document.createElement(WeiXin.HQ_MUSIC_URL);
		hQMusicUrlElement.setTextContent(this.hQMusicUrl);
		Element thumbMediaIdElement = document.createElement(WeiXin.THUMBMEDIAID);
		thumbMediaIdElement.setTextContent(this.thumbMediaId);

		musicElement.appendChild(titleElement);
		musicElement.appendChild(descriptionElement);
		musicElement.appendChild(musicUrlElement);
		musicElement.appendChild(hQMusicUrlElement);
		musicElement.appendChild(thumbMediaIdElement);
		root.appendChild(musicElement);
		
		document.appendChild(root);
	}
	

	@Override
	public void read(Document document) { }
	
	
	
	
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
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return hQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}



	/**
	 * @return the hQMusicUrl
	 */
	public String gethQMusicUrl() {
		return hQMusicUrl;
	}



	/**
	 * @param hQMusicUrl the hQMusicUrl to set
	 */
	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
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
	 
}
