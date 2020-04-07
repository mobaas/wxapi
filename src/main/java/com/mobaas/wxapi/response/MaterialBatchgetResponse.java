/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.model.MediaItem;
import com.mobaas.wxapi.model.News;
import com.mobaas.wxapi.model.NewsItem;

public class MaterialBatchgetResponse<T> extends WxApiResponse {

	private String type;
	
	private int totalCount;
	private int itemCount;
	private List<T> mediaList;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public List<T> getMediaList() {
		return mediaList;
	}
	
	@Override
	public void parse() throws IOException {
		super.parse();
		
		totalCount = getValue("total_count");
		itemCount = getValue("item_count");
		
		mediaList = new ArrayList<T>();
		List<Map<String, Object>> list = getValue("item");
		if ("news".equals(getType())) {
			
			for (Map<String, Object> map : list) {
				
				News news = new News();
				news.setMediaId( (String)map.get("media_id") );
				news.setUpdateTime( (String)map.get("update_time") );

				List<Map<String, Object>> itemlist = (List<Map<String, Object>>)map.get("content");
			    for (Map<String, Object> item : itemlist) {
			    	NewsItem nitm = new NewsItem();
			    	nitm.setTitle( (String)item.get("title") );
			    	nitm.setThumbMediaId( (String)item.get("thumb_media_id") ); 
			    	nitm.setAuthor( (String)item.get("author") );
			    	nitm.setContentSourceUrl( (String)item.get("content_source_url") );
			    	nitm.setUrl( (String)item.get("url") );
			    	nitm.setContent( (String)item.get("content") );
			    	nitm.setDigest( (String)item.get("digest") );
			    	nitm.setShowCoverPic( (Integer)item.get("show_cover_pic") );
			    
			    	news.addItem(nitm);
			    }
				
				mediaList.add((T)news);
			}
			
		} else {
			
			for (Map<String, Object> map : list) {
	
				MediaItem mi = new MediaItem();
				mi.setMediaId( (String)map.get("media_id") );
				mi.setName( (String)map.get("name") );
				mi.setUpdateTime( (String)map.get("update_time") );
				mi.setUrl( (String)map.get("url") );
			    
				mediaList.add((T)mi);
			}
		}
	}
}
