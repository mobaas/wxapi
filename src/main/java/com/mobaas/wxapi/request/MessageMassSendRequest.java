/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxPostRequest;

/**
 * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
 * @author billy
 *
 */
public class MessageMassSendRequest extends WxPostRequest<WxApiResponse> {

	private List<String> users;
	private String msgType;
	private Map<String, Object> data;
	private int sendIgnoreReprint;
	
	@Override
	public String getAction() { return "message/mass/send"; }

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", users);
		map.put("msgtype", msgType);
		map.put(msgType, data);
		map.put("send_ignore_reprint", sendIgnoreReprint);
		return map;
	}
}
