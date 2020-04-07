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
 * 查询群发消息发送状态【订阅号与服务号认证后均可用】
 * @author billy
 *
 */
public class MessageMassGetRequest extends WxGetRequest<WxApiResponse> {

	private String msgId;
	
	@Override
	public String getAction() { return "message/mass/get?msg_id=" + msgId; }
}
