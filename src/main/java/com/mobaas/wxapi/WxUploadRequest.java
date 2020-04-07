/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.mobaas.wxapi.WxApiRequest;
import com.mobaas.wxapi.WxApiResponse;

/**
 * 上传请求基类
 * @author billy
 *
 * @param <T>
 */
public abstract class WxUploadRequest<T extends WxApiResponse> extends WxApiRequest<T> {
	
	private String filename;
	
	private byte[] fileData;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	@Override
	public HttpUriRequest getRequest(String url) {

		HttpEntity reqEntity = MultipartEntityBuilder.create()
				.addBinaryBody("media", fileData, ContentType.MULTIPART_FORM_DATA, filename)
    				.build();
    	
    		HttpPost post = new HttpPost(url);
    		post.setEntity(reqEntity);
    	 
    		return post;
	}
	
}
