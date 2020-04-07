/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.model;

public class NewsItem {
	
	/**
	 * req, 图文消息的标题
	 */
	private String title;

	/**
	 * req, 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得 
	 */
	private String thumbMediaId; 

    /**
     * 图文消息的作者
     */
	private String author;

    /**
     * 在图文消息页面点击“阅读原文”后的页面
     */
	private String contentSourceUrl;

    /**
     * 查询列表时返回， 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     */
	private String url;

    /**
     * req, 图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用
     */
    private String content;

    /**
     * 图文消息的描述
     */
    private String digest;

    /**
     * 是否显示封面，1为显示，0为不显示
     */
    private int showCoverPic;
    
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getShowCoverPic() {
		return showCoverPic;
	}

	public void setShowCoverPic(int showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
    
}
