/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxUploadRequest;

/**
 * 新增临时素材(3天后自动删除)。
 * 原“上传多媒体文件”接口
 * @author billy
 *
 */
public class MediaUploadRequest extends WxUploadRequest<WxApiResponse> {

	/**
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 */
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getAction() { 
		return "media/upload?type=" + type; 
	}

}
