/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	/**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     * 必填
     */
	private String name;

    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     * 必填
     */
    private String type;

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节
     * click等点击类型必须
     */
    private String key;

    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * view、miniprogram类型必须
     */
    private String url;

    /**
     * 调用新增永久素材接口返回的合法media_id
     * media_id类型和view_limited类型必须
     */
    private String mediaId;

    /**
     * 小程序的appid（仅认证公众号可配置）
     * miniprogram类型必须
     */
    private String appId;

    /**
     * 小程序的页面路径
     * miniprogram类型必须
     */
    private String pagePath;

    /**
     * 二级菜单数组，个数应为1~5个
     */
    private List<MenuItem> subItems;

    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public List<MenuItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<MenuItem> subItems) {
		this.subItems = subItems;
	}
	
	public void addItem(MenuItem mi) {
		if (subItems == null) {
			subItems = new ArrayList<MenuItem>();
		}
		
		subItems.add(mi);
	}
}
