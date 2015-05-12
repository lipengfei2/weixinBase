package com.weixin.web;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.DefaultSession;
import com.weixin.HandleMessageAdapter;
import com.weixin.msg.MsgEvent;
import com.weixin.msg.MsgLocation;
import com.weixin.msg.MsgText;
import com.weixin.msg.MsgVoice;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 微信核心
 * @author baizhongxdycom
 *
 */
public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String hps="http://weixin.niusiji.cn/weixin/userServlet";
	//static String appid="wx99ed84876db4bea7";
	//static String secret="8fd079195ac8df7c176f7d1966519f16";
	//TOKEN 是你在微信平台开发模式中设置的哦
	public static final String TOKEN = "126buy";
	


	/**
	 * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等
	 *
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		InputStream is  = request.getInputStream();
		OutputStream os = response.getOutputStream();
	
		final DefaultSession session = DefaultSession.newInstance(); 
		//文字识别
		session.addOnHandleMessageListener(new HandleMessageAdapter(){
			public void onTextMsg(MsgText msg) {	
			}
		});
		
		// 语音识别消息
		session.addOnHandleMessageListener(new HandleMessageAdapter(){ 
			public void onVoiceMsg(MsgVoice msg) {
				
			}
		});
		
		// 处理事件
		session.addOnHandleMessageListener(new HandleMessageAdapter() {
			public void onEventMsg(MsgEvent msg) {
				
			} 
		});
		
		// 处理地理位置
		session.addOnHandleMessageListener(new HandleMessageAdapter(){
			public void onLocationMsg(MsgLocation msg) {
				MsgText reMsg = new MsgText();
				reMsg.setFromUserName(msg.getToUserName());
				reMsg.setToUserName(msg.getFromUserName());
				reMsg.setCreateTime(msg.getCreateTime()); 
				session.callback(reMsg);// 回传消息 
			}			
		});
		
		session.process(is, os,request);//处理微信消息 
		session.close();//关闭Session 
	}

}

