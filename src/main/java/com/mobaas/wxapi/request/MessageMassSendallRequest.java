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
 * 根据分组进行群发【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MessageMassSendallRequest extends WxPostRequest<WxApiResponse> {

	private boolean isToAll;
	private String tagId;
	private String msgType;
	private Map<String, Object> data;
	private int sendIgnoreReprint;
	
	@Override
	public String getAction() { return "message/mass/sendall"; }

	@Override
	protected Object getPostData() {
		
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("is_to_all", isToAll);
		if (!isToAll) {
			filter.put("tag_id", tagId);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filter", filter);
		map.put("msgtype", msgType);
		map.put(msgType, data);
		map.put("send_ignore_reprint", sendIgnoreReprint);
		
		return map;
	}
}
