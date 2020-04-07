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

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxPostRequest;

/**
 * 预览接口【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MessageMassPreviewRequest extends WxPostRequest<WxApiResponse> {

	private String toUserName;
	private String msgType;
	private Map<String, Object> data;
	
	@Override
	public String getAction() { return "message/mass/preview"; }

	@Override
	protected Object getPostData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("touser", toUserName);
		map.put("msgtype", msgType);
		map.put(msgType, data);
		return map;
	}
}
