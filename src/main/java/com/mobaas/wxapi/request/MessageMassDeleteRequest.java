/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.WxGetRequest;

/**
 * 删除群发【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MessageMassDeleteRequest extends WxGetRequest<WxApiResponse> {

	private String msgId;
	
	@Override
	public String getAction() { return "message/mass/delete?msg_id=" + msgId; }
}
