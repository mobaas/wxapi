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
 * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MediaUploadimgRequest extends WxUploadRequest<WxApiResponse> {

	@Override
	public String getAction() { 
		return "media/uploadimg"; 
	}

}
