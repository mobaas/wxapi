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
 * 上传图文消息素材【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MediaUploadnewsRequest extends WxPostRequest<WxApiResponse> {

	private List<NewsItem> newsList;
	
	public List<NewsItem> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsItem> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String getAction() { return "media/uploadnews"; }

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articles", newsList);
		return map;
	}
	
	
}
