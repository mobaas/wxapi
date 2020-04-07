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
import com.mobaas.wxapi.response.MaterialBatchgetResponse;

/**
 * 获取素材列表（媒体）
 * @author billy
 *
 * @param <T>
 */
public class MaterialBatchgetRequest<T> extends WxPostRequest<MaterialBatchgetResponse<T>> {

	private String type;
	private int offset;
	private int count;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String getAction() {
		return "material/batchget_material";
	}
	
	@Override
	public MaterialBatchgetResponse<T> createResponse() {
		MaterialBatchgetResponse<T> resp = new MaterialBatchgetResponse<T>();
		resp.setType(type);
		
		return resp;
	}

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("offset", offset);
		map.put("count", count);
		return map;
	}

}
