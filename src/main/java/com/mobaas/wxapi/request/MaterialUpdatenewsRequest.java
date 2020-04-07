/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxPostRequest;
import com.mobaas.wxapi.model.NewsItem;

/**
 * 修改永久图文素材
 * @author billyzh
 *
 */
public class MaterialUpdatenewsRequest extends WxPostRequest<WxApiResponse> {

	private String mediaId;
	private int index;
	private List<NewsItem> newsList;
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<NewsItem> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsItem> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String getAction() {
		return "material/update_news";
	}

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media_id", mediaId);
		map.put("index", index);
		map.put("articles", newsList);
		return map;
	}
}
