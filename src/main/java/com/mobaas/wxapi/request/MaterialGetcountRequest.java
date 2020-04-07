/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxGetRequest;
import com.mobaas.wxapi.response.MaterialGetcountResponse;

/**
 * 获取素材总数
 * @author billy
 *
 */
public class MaterialGetcountRequest extends WxGetRequest<MaterialGetcountResponse> {

	@Override
	public String getAction() {
		return "material/get_materialcount";
	}
	
	@Override
	public MaterialGetcountResponse createResponse() {
		return new MaterialGetcountResponse();
	}

}
