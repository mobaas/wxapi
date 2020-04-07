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
 * 新增永久图文素材
 * @author billyzh
 *
 */
public class MaterialAddnewsRequest extends WxPostRequest<WxApiResponse> {

	private List<NewsItem> newsList;
	
	public void setNewsList(List<NewsItem> list) {
		newsList = list;
	}
	
	@Override
	public String getAction() {
		return "material/add_news";
	}

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articles", newsList);
		return map;
	}
}
