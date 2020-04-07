/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import org.apache.http.client.methods.HttpUriRequest;

/**
 * Api请求基类
 * @author billy
 *
 * @param <T>
 */
public abstract class WxApiRequest<T extends WxApiResponse> {

	public abstract String getAction();
	
	public abstract HttpUriRequest getRequest(String url);
	
	public T createResponse() {
		WxApiResponse resp = new WxApiResponse();
		return (T)resp;
	}
}
