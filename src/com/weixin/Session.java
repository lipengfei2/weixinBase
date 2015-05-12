package com.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.weixin.msg.HeadMsg;
import com.weixin.msg.Msg;
import com.weixin.msg.MsgEvent;
import com.weixin.msg.MsgImage;
import com.weixin.msg.MsgLink;
import com.weixin.msg.MsgLocation;
import com.weixin.msg.MsgText;
import com.weixin.msg.MsgVideo;
import com.weixin.msg.MsgVoice;


/**
 * 抽象会话
 * 此会话声明周期在一个请求响应内。
 * 通过继承类实现各种消息的处理方法
 * @author marker
 * */
public abstract class Session {

	
	//输入流
	private InputStream is;
	//输出流
	private OutputStream os;
	
	/** Document构建类 */
	private static DocumentBuilder builder;
	private static TransformerFactory tffactory;
	  
	static{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		//格式化工厂对象
		tffactory = TransformerFactory.newInstance();
	}
	
	public Session() { }


	
	/**
	 * 解析微信消息，并传递给对应方法
	 * @param is 输入流
	 * @param os 输出流
	 */
	public void process(InputStream is, OutputStream os,HttpServletRequest request) {
		this.os = os;
		try {
			Document document = builder.parse(is);
			HeadMsg head = new HeadMsg();
			head.read(document);
			String type = head.getMsgType();
			if(WeiXin.MSG_TYPE_TEXT.equals(type)){//文本消息
				MsgText msg = new MsgText(head);
				msg.read(document);
				this.onTextMsg(msg);
			}else if(WeiXin.MSG_TYPE_IMAGE.equals(type)){//图片消息
				MsgImage msg = new MsgImage(head);
				msg.read(document);
				this.onImageMsg(msg);
			}else if(WeiXin.MSG_TYPE_EVENT.equals(type)){//事件推送
				MsgEvent msg = new MsgEvent(head);
				msg.read(document);
				this.onEventMsg(msg);
			}else if(WeiXin.MSG_TYPE_LINK.equals(type)){//链接消息
				MsgLink msg = new MsgLink(head);
				msg.read(document);
				this.onLinkMsg(msg);
			}else if(WeiXin.MSG_TYPE_LOCATION.equals(type)){//地理位置消息
				MsgLocation msg = new MsgLocation(head);
				msg.read(document);
				this.onLocationMsg(msg);
			}else if(WeiXin.MSG_TYPE_VOICE.equals(type)){
				MsgVoice msg = new MsgVoice(head);
				msg.read(document);
				this.onVoiceMsg(msg);
			}else if(WeiXin.MSG_TYPE_VIDEO.equals(type)){
				MsgVideo msg = new MsgVideo(head);
				msg.read(document);
				this.onVideoMsg(msg);
			}else{
				this.onErrorMsg(-1);//这里暂时这样处理的
			}
		} catch (SAXException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}






	/**
	 * 回传消息给微信服务器
	 * 只能再接收到微信服务器消息后，才能调用此方法
	 * @param msg 消息对象（支持：文本、音乐、图文）
	 * */
	public void callback(Msg msg){
		Document document = builder.newDocument();
		msg.write(document);
		try {
			Transformer transformer = tffactory.newTransformer();
			
			;
			transformer.transform(new DOMSource(document), new StreamResult(new OutputStreamWriter(os,"utf-8")));
		} catch ( Exception e) { 
			e.printStackTrace();// 保存dom至目输出流
		}
	}
	
	
	/**
	 * 关闭
	 * */
	public void close(){
		try {
			if(is != null){
				is.close();
			}
			if(os != null){
				os.flush();
				os.close();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
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
	 * 收到语音识别消息
	 * @param msg
	 */
	public abstract void onVoiceMsg(MsgVoice msg);
	

	/**
	 * 收到视频消息
	 * @param msg
	 */
	public abstract void onVideoMsg(MsgVideo msg);
	
	
	/**
	 * 错误消息
	 * @param msg
	 */
	public abstract void onErrorMsg(int errorCode);
 
	
}
