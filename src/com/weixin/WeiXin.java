package com.weixin;

public class WeiXin {

	/**
	 * 下面部分定义的常量是微信消息是哪一种微信消息 HeadMsg的属性msgType的值需要从下面的值中选择
	 *  */
	/** 文本消息 */
	public static final String MSG_TYPE_TEXT = "text";
	/** 图片消息 */
	public static final String MSG_TYPE_IMAGE = "image";
	/** 音乐消息 */
	public static final String MSG_TYPE_MUSIC = "music";
	/** 地理位置消息 */
	public static final String MSG_TYPE_LOCATION = "location";
	/** 链接消息 */
	public static final String MSG_TYPE_LINK = "link";
	/** 图文消息 */
	public static final String MSG_TYPE_IMAGE_TEXT = "news";
	/** 事件消息 */
	public static final String MSG_TYPE_EVENT = "event";
	/** 语音消息 */
	public static final String MSG_TYPE_VOICE = "voice";
	/** 视频消息 */
	public static final String MSG_TYPE_VIDEO = "video";
	/** 多客服消息 */
	public static final String MSG_TYPE_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
	

	
	
	
	
	
	
	
	/**
	 *  微信接收和回复的都是xml格式的数据 下面列出不同类型的消息的xml
	 * 下面是xml节点的所有名称        
	 * */
	/**  通用的部分  */
	public static final String ROOT = "xml";
	public static final String TO_USER_NAME = "ToUserName";
	public static final String FROM_USER_NAME = "FromUserName";
	public static final String CREATE_TIME = "CreateTime";
	public static final String MSG_TYPE = "MsgType";
	/**
	 * 文本消息（可接收、可回复）    Content、 MsgId（只在接收时 ）
	 * 图片消息（可接收、可回复）    PicUrl、MediaId 、 MsgId（只在接收时 ）
	 * 语音消息（可接收、可回复）    Format 、MediaId 、MsgId（只在接收时 ）Recognition（语音识别结果，UTF8编码） 
	 * 视频消息（可接收、可回复）MediaId、ThumbMediaIdMsgId、MsgId（只在接收时 ）
	 * 地理位置消息（可接收） Location_X、 Location_Y、 Scale、 MsgId 
	 * 链接消息（可接收）   Title  Description  Url  MsgId 
	 * 事件消息（可接收）       
	 *    1.关注/取消关注事件        Event（subscribe、unsubscribe ） 
	 *    2.扫描带参数二维码事件  Event（subscribe ）、  EventKey（事件KEY值，qrscene_为前缀，后面为二维码的参数值 ）、Ticket（二维码的ticket，可用来换取二维码图片 ）
	 *    3.上报地理位置事件  Event、 Latitude 、Longitude 、 Precision 
	 *    4.自定义菜单事件
	 *       1.点击菜单拉取消息时的事件推送 Event（CLICK）、EventKey（事件KEY值，与自定义菜单接口中KEY值对应 ）
	 *       2.点击菜单跳转链接时的事件推送 Event（VIEW ）、EventKey（事件KEY值，设置的跳转URL  ）
	 * 音乐消息（可回复） Title、Description、MusicURL（音乐链接 ） 、HQMusicUrl（高质量音乐链接，WIFI环境优先使用该链接播放音乐 ） 、ThumbMediaId（缩略图的媒体id，通过上传多媒体文件，得到的id）
	 * 回复图文消息 （可回复） ArticleCount（图文消息个数，限制为10条以内 ）
	 *                  Articles  （多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应 ）
	 *                  Title（图文消息标题 ）
	 *                  Description （图文消息描述 ）
	 *                  PicUrl （图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 ）
	 *                  Url （点击图文消息跳转链接 ）
	 *
	 * ***/ 
	public static final String MSG_ID = "MsgId";
	public static final String CONTENT = "Content";
	public static final String FUNC_FLAG = "FuncFlag";
	public static final String PIC_URL = "PicUrl";
	public static final String TITLE = "Title";
	public static final String DESCRITION = "Description";
	public static final String URL = "Url";
	public static final String MUSIC_URL = "MusicUrl";
	public static final String HQ_MUSIC_URL = "HQMusicUrl";
	public static final String MUSIC = "Music";
	public static final String EVENT = "Event";
	public static final String EVENT_KEY = "EventKey";
	public static final String TICKET = "Ticket";
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	public static final String PRECISION = "Precision";
	public static final String LOCATION_X = "Location_X";
	public static final String LOCATION_Y = "Location_Y";
	public static final String SCALE = "Scale";
	public static final String LABEL = "Label";
	public static final String ARTICLE_COUNT = "ArticleCount";
	public static final String ARTICLES = "Articles";
	public static final String ITEM = "item";
	public static final String MEDIAID = "MediaId";
	public static final String FORMAT = "Format";
	public static final String RECOGNITION = "Recognition";
	public static final String THUMBMEDIAID = "ThumbMediaId";
	public static final String IMAGE = "Image";
	public static final String VOICE = "Voice";
	public static final String VIDEO = "Video";
	public static final String TRANSINFO = "TransInfo";
	public static final String KFACCOUNT = "KfAccount";
	
	
	
	
	
	
	
	/**如果消息类型是事件消息则消息类型分为下面几种  */
	public static final String SUBSCRIBE = "subscribe";
	public static final String UNSUBSCRIBE = "unsubscribe";
	public static final String CLICK = "CLICK";
	public static final String SCAN = "SCAN";// 用户已关注时的事件推送
	public static final String LOCATION = "LOCATION";//
	
	
	
	
	
	
	
}
