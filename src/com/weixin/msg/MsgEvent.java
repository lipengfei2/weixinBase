package com.weixin.msg;

import org.w3c.dom.Document;

import com.weixin.WeiXin;

/**
 * 事件消息
 * @author 牛司机
 * @version 2.0
 *  * 注意： 此消息只能是微信服务器推送过来
 * */
public class MsgEvent extends Msg {
	

	
	/**事件类型*/
	private String event;
	/**事件KEY值，与自定义菜单接口中KEY值对应*/
	private String eventKey;
	/** 二维码的ticket，可用来换取二维码图片*/
	private String ticket;
	/** 地理位置纬度*/
	private String latitude;
	/** 地理位置经度*/
	private String longitude;
	/** 地理位置精度*/
	private String precision;
	
	
	public MsgEvent() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_EVENT);
	}

	public MsgEvent(HeadMsg head) {
		this.head = head;
	}

	/**
	 * 因为事件消息都是由微信服务器发送给我们的，我们不用发给微信服务器，因此不用实现write
	 * */
	@Override
	public void write(Document document) { }
	
	
	@Override
	public void read(Document document) {
		this.event = getElementContent(document, WeiXin.EVENT);
		//用户未关注时，进行关注后的事件推送
		if(WeiXin.SUBSCRIBE.equals(this.event) || WeiXin.UNSUBSCRIBE.equals(this.event) || WeiXin.SCAN.equals(this.event)){
			this.eventKey = getElementContent(document, WeiXin.EVENT_KEY);
			this.ticket = getElementContent(document, WeiXin.TICKET);
		}else if(WeiXin.LOCATION.equals(this.event)){// 上报地理位置事件
			this.latitude = getElementContent(document, WeiXin.LATITUDE);
			this.longitude = getElementContent(document, WeiXin.LONGITUDE); 
			this.precision = getElementContent(document, WeiXin.PRECISION);
		}else if(WeiXin.CLICK.equals(this.event)){// 自定义菜单事件
			this.eventKey = getElementContent(document, WeiXin.EVENT_KEY);
		}
	}
	
	
	
	
	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
	}


	public String getEventKey() {
		return eventKey;
	}


	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}


	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}


	
	
	
	
	
}
