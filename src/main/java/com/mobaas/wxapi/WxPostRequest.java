/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Post请求基类
 * @author billy
 *
 * @param <T>
 */
public abstract class WxPostRequest<T extends WxApiResponse> extends WxApiRequest<T> {

	protected abstract Object getPostData();
	
	@Override
	public HttpUriRequest getRequest(String url) {
		
		ObjectMapper jsonMapper = new ObjectMapper();
		String jsonData = "";
		try {
			jsonData = jsonMapper.writeValueAsString(getPostData());
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
		}
		
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json; charset=utf-8");
		post.setEntity(new StringEntity(jsonData, Charset.forName("utf-8")));
		
		return post;
	}


}
