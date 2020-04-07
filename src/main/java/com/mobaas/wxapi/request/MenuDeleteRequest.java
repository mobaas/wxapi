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
 * 自定义菜单删除
 * @author billy
 *
 */
public class MenuDeleteRequest extends WxGetRequest<WxApiResponse> {

	public String getAction() { return "menu/delete"; }
	
}
