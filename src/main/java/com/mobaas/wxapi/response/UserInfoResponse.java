/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.response;

import java.io.IOException;

import com.mobaas.wxapi.WxApiResponse;

public class UserInfoResponse extends WxApiResponse {

	private String nickname;
	private String headimgUrl;
	
	public String getNickname() { return nickname; }
	
	public String getHeadimgUrl() { return headimgUrl; }
	
	@Override
	public void parse() throws IOException {
		super.parse();
		
		nickname = getValue("nickname");
        headimgUrl = getValue("headimgurl");
	}
}
