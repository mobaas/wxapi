/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.request.MediaUploadimgRequest;

public class MediaTest extends BaseTest {
	
	@Test
	public void testMediaUploadimg() throws IOException {
		MediaUploadimgRequest request = new MediaUploadimgRequest();
		request.setFilename("test.png");
		
		InputStream inStream = this.getClass().getResourceAsStream("/test.png");
		request.setFileData(toByteArray(inStream));
		
		WxApiResponse response = apiClient.execute(request);
		
		assertResponse(response);
		
		assertNotNull("url 不存在", response.getValue("url"));
	
	}
	
}
