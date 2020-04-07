/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mobaas.wxapi.WxApiResponse;

public class UserGetResponse extends WxApiResponse {

	private int total;
	private int count;
	private List<String> userList;
	private String nextOpenId;
	
	public int getTotal() {
		return total;
	}

	public int getCount() {
		return count;
	}

	public List<String> getUserList() {
		return userList;
	}

	public String getNextOpenId() {
		return nextOpenId;
	}

	@Override
	public void parse() throws IOException {
		super.parse();
		
		total = getValue("total");
		count = getValue("count");
		
		if (count > 0) {
			Map map = getValue("data");
			userList = (List<String>)map.get("openid");
			nextOpenId = (String)map.get("next_openid");
		}
	}
}
