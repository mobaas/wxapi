/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mobaas.wxapi.WxApiResponse;
import com.mobaas.wxapi.request.MaterialAddRequest;
import com.mobaas.wxapi.request.MaterialDeleteRequest;
import com.mobaas.wxapi.request.MaterialGetcountRequest;
import com.mobaas.wxapi.response.MaterialGetcountResponse;

public class MaterialTest extends BaseTest {
	
	@Test
	public void testMaterialAddimg() throws IOException {
		MaterialAddRequest request = new MaterialAddRequest();
		request.setType("image");
		request.setFilename("test.png");
		
		InputStream inStream = this.getClass().getResourceAsStream("/test.png");
		request.setFileData(toByteArray(inStream));
		
		WxApiResponse response = apiClient.execute(request);
		
		assertResponse(response);
		
		String mediaId = response.getValue("media_id");
		assertNotNull("media_id 不存在", mediaId);
		assertNotNull("url 不存在", response.getValue("url"));
		
		MaterialDeleteRequest request2 = new MaterialDeleteRequest();
		request2.setMediaId(mediaId);
		WxApiResponse response2 = apiClient.execute(request2);
		
		assertResponse(response2);
	}
	
	@Test
	public void testMaterialGetcount() throws IOException {
	
		MaterialGetcountRequest request = new MaterialGetcountRequest();
		MaterialGetcountResponse response = apiClient.execute(request);
		
		assertResponse(response);

		assertTrue("没有图片素材", response.getImageCount() > 0);
		assertTrue("没有图文素材", response.getNewsCount() > 0);
		assertTrue("没有视频素材", response.getVideoCount() > 0);
		assertTrue("没有音频素材", response.getVoiceCount() > 0);
		
	}
	
}
