/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.model.MediaItem;
import com.mobaas.wxapi.model.News;
import com.mobaas.wxapi.model.NewsItem;

public class MaterialGetResponse<T> extends WxApiResponse {

	private String type;
	private T media;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T getMedia() {
		return media;
	}
	
	@Override
	public void parse() throws IOException {
		super.parse();
		
		String mediaId = getValue("media_id");
		String updateTime = getValue("update_time");
		
		if ("news".equals(getType())) {
			
			News news = new News();
			news.setMediaId( mediaId );
			news.setUpdateTime( updateTime );

			List<Map<String, Object>> itemlist = getValue("news_item");
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
			
		    media = (T)news;
			
		} else {
			
			MediaItem mi = new MediaItem();
			mi.setMediaId( mediaId );
			mi.setUpdateTime( updateTime );
			
			String name = getValue("name");
			String url = getValue("url");
			mi.setName( name );
			mi.setUrl( url );
			    
			media = (T)mi;
		}
	}
}
