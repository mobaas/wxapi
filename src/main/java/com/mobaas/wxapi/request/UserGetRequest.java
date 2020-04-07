/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import com.mobaas.wxapi.StringUtils;
import com.mobaas.wxapi.WxApiRequest;
import com.mobaas.wxapi.response.UserGetResponse;

/**
 * 获取用户列表
 * @author billy
 *
 */
public class UserGetRequest extends WxApiRequest<UserGetResponse> {

	private String nextOpenId;
	public void setNextOpenId(String nextOpenId) {
		this.nextOpenId = nextOpenId;
	}
	
	public String getAction() {
		if (StringUtils.isEmpty(nextOpenId))
			return "user/get";
		
		return "user/get?next_openid=" + nextOpenId;
	}
	
	@Override
	public UserGetResponse createResponse() {
		return new UserGetResponse();
	}

	@Override
	public HttpUriRequest getRequest(String url) {
		return new HttpGet(url);
	}

}
