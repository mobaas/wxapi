/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import java.util.HashMap;
import java.util.Map;

import com.mobaas.wxapi.WxPostRequest;
import com.mobaas.wxapi.response.MaterialGetResponse;

/**
 * 获取永久素材
 * @author billy
 *
 * @param <T>
 */
public class MaterialGetRequest<T> extends WxPostRequest<MaterialGetResponse<T>> {

	private String mediaId;
	private String type;
	
	@Override
	public String getAction() {
		return "material/get_material";
	}

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("media_id", mediaId);
		return null;
	}
	
	public MaterialGetResponse<T> createResponse() {
		MaterialGetResponse<T> resp = new MaterialGetResponse<T>();
		resp.setType( type );
		return resp;
	}
}
