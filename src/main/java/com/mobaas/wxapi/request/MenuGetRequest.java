/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.request;

import com.mobaas.wxapi.WxGetRequest;
import com.mobaas.wxapi.response.MenuGetResponse;

/**
 * 自定义菜单查询
 * @author billy
 *
 */
public class MenuGetRequest extends WxGetRequest<MenuGetResponse>{

	@Override
	public String getAction() { return "menu/get"; }

	@Override
	public MenuGetResponse createResponse() {
		return new MenuGetResponse();
	}

}
