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
 * 添加素材
 * @author billy
 *
 */
public class MaterialAddRequest extends WxUploadRequest<WxApiResponse> {

	/**
	 * 素材文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
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
		return "material/add_material?type=" + type;
	}

	
}
