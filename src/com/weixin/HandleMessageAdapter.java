package com.weixin;

import com.weixin.msg.MsgEvent;
import com.weixin.msg.MsgImage;
import com.weixin.msg.MsgLink;
import com.weixin.msg.MsgLocation;
import com.weixin.msg.MsgText;
import com.weixin.msg.MsgVideo;
import com.weixin.msg.MsgVoice;



/**
 * 处理消息适配器(适配器模式)
 * @author marker
 * */
public class HandleMessageAdapter implements HandleMessageListener {

	public void onTextMsg(MsgText msg) {
		// TODO Auto-generated method stub
		
	}

	public void onImageMsg(MsgImage msg) {
		// TODO Auto-generated method stub
		
	}

	public void onEventMsg(MsgEvent msg) {
		// TODO Auto-generated method stub
		
	}

	public void onLinkMsg(MsgLink msg) {
		// TODO Auto-generated method stub
		
	}

	public void onLocationMsg(MsgLocation msg) {
		// TODO Auto-generated method stub
		
	}

	public void onErrorMsg(int errorCode) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.marker.weixin.HandleMessageListener#onVoiceMsg(org.marker.weixin.msg.Msg4Voice)
	 */
	public void onVoiceMsg(MsgVoice msg) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.marker.weixin.HandleMessageListener#onVideoMsg(org.marker.weixin.msg.Msg4Video)
	 */
	public void onVideoMsg(MsgVideo msg) {
		// TODO Auto-generated method stub
		
	}

}
