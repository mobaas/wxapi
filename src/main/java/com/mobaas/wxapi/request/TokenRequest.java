/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxGetRequest;
import com.mobaas.wxapi.response.TokenResponse;

public class TokenRequest extends WxGetRequest<TokenResponse> {

	private String appId;
	private String appSecret;
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public String getAction() {
		return String.format("token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
	}
	
	@Override
	public TokenResponse createResponse() {
		return new TokenResponse();
	}

}
