/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxGetRequest;

/**
 * 获取临时素材
 * @author billy
 *
 */
public class MediaGetRequest extends WxGetRequest<WxApiResponse> {

	private String mediaId;
	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String getAction() { 
		return "media/get?media_id=" + mediaId; 
	}
}
