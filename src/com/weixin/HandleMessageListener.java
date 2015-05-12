package com.weixin;

import com.weixin.msg.MsgEvent;
import com.weixin.msg.MsgImage;
import com.weixin.msg.MsgLink;
import com.weixin.msg.MsgLocation;
import com.weixin.msg.MsgText;
import com.weixin.msg.MsgVideo;
import com.weixin.msg.MsgVoice;

/**
 * 主要用于接收微信服务器消息的接口
 * @author marker
 * */
public interface HandleMessageListener {

	/**
	 * 收到文本消息
	 * @param msg
	 */
	public abstract void onTextMsg(MsgText msg);
	
	/**
	 * 收到图片消息
	 * @param msg
	 */
	public abstract void onImageMsg(MsgImage msg);
	
	/**
	 * 收到事件推送消息
	 * @param msg
	 */
	public abstract void onEventMsg(MsgEvent msg);
	
	/**
	 * 收到链接消息
	 * @param msg
	 */
	public abstract void onLinkMsg(MsgLink msg);
	
	/**
	 * 收到地理位置消息
	 * @param msg
	 */
	public abstract void onLocationMsg(MsgLocation msg);
	
	/**
	 * 语音识别消息
	 * @param msg
	 */
	public abstract void onVoiceMsg(MsgVoice msg);
	
	/**
	 * 错误消息
	 * @param msg
	 */
	public abstract void onErrorMsg(int errorCode);

	/**
	 * 视频消息
	 * @param msg
	 */
	public abstract void onVideoMsg(MsgVideo msg);

}
