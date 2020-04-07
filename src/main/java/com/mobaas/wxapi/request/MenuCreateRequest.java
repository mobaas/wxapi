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
import com.mobaas.wxapi.model.MenuItem;

/**
 * 自定义菜单创建
 * @author billy
 *
 */
public class MenuCreateRequest extends WxPostRequest<WxApiResponse> {

	private MenuItem[] menuItems;
	
	public MenuItem[] getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public String getAction() { return "menu/create"; }
	
	@Override
	public Map<String, Object> getPostData() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("button", menuItems);
		
		return map;
	}
	
}
