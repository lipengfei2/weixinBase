package com.weixin.msg;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.weixin.WeiXin;

/**
 * 图文消息（只能回复）
 * @author 牛司机
 * @version 2.0
 */
public class MsgImageText extends Msg {

	// 图文消息个数，限制为10条以内
	private String articleCount;
	// 图文消息的数据
	private List<DataImage> items = new ArrayList<DataImage>(3);
 
	
	
	/**
	 * 默认构造
	 * */
	public MsgImageText() {
		this.head = new HeadMsg();
		this.head.setMsgType(WeiXin.MSG_TYPE_IMAGE_TEXT);
	}
	
	@Override
	public void write(Document document) {
		Element root = document.createElement(WeiXin.ROOT);
		head.write(root, document);
		Element articleCountElement = document.createElement(WeiXin.ARTICLE_COUNT);
		articleCountElement.setTextContent(this.articleCount);
		
		Element articlesElement = document.createElement(WeiXin.ARTICLES);
		int size = Integer.parseInt(this.articleCount);
		for(int i = 0; i<size; i++){
			DataImage currentItem = items.get(i);//获取当前
			Element itemElement = document.createElement(WeiXin.ITEM);
			Element titleElement = document.createElement(WeiXin.TITLE);
			titleElement.setTextContent(currentItem.getTitle());
			Element descriptionElement = document.createElement(WeiXin.DESCRITION);
			descriptionElement.setTextContent(currentItem.getDescription());
			Element picUrlElement = document.createElement(WeiXin.PIC_URL);
			picUrlElement.setTextContent(currentItem.getPicUrl());
			Element urlElement = document.createElement(WeiXin.URL);
			urlElement.setTextContent(currentItem.getUrl());
			itemElement.appendChild(titleElement);
			itemElement.appendChild(descriptionElement);
			itemElement.appendChild(picUrlElement);
			itemElement.appendChild(urlElement);
			
			articlesElement.appendChild(itemElement);
		}
		
 

		root.appendChild(articleCountElement);
		root.appendChild(articlesElement);
		
		document.appendChild(root);
	}

	@Override
	public void read(Document document) {
		// TODO Auto-generated method stub
		
	}
  
	
	public void addItem(DataImage item){
		this.items.add(item);
		this.reflushArticleCount();
	}
	
	public void removeItem(int index){
		this.items.remove(index);
		this.reflushArticleCount();
	}
	
	
	
	/**
	 * 刷新当前文章条数
	 * */
	private void reflushArticleCount(){
		this.articleCount = ""+this.items.size();
	}
	
	
	
	
}
