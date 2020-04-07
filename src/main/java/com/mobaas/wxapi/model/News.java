/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.model;

import java.util.ArrayList;
import java.util.List;

public class News {
	private String mediaId;
	private String updateTime;
	private List<NewsItem> itemList;
	
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public List<NewsItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<NewsItem> itemList) {
		this.itemList = itemList;
	}
	
	public void addItem(NewsItem item) {
		if (itemList == null) {
			itemList = new ArrayList<NewsItem>();
		}
		
		itemList.add(item);
	}
}
