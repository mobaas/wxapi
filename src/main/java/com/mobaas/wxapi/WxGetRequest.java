/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Get请求基类
 * @author billy
 *
 * @param <T>
 */
public abstract class WxGetRequest<T extends WxApiResponse> extends WxApiRequest<T> {

	@Override
	public HttpUriRequest getRequest(String url) {
		return new HttpGet(url);
	}


}
