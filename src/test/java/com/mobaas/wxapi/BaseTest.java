/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;

import com.mobaas.wxapi.WxApiClient;
import com.mobaas.wxapi.WxApiResponse;

public class BaseTest {

	protected static WxApiClient apiClient;
	
	@BeforeClass
	public static void setUp() {
		InputStream inStream = BaseTest.class.getResourceAsStream("/test.properties");
		Properties props = new Properties();
		try {
			props.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String appId = props.getProperty("app_id");
		assertNotNull("请设置app_id", appId);
		
		String appSecret = props.getProperty("app_secret");
		assertNotNull("请设置app_secret", appSecret);
		
		apiClient = WxApiClient.create(appId, appSecret);
	}
	
	protected void assertResponse(WxApiResponse response) {
		assertNotNull(response);
		assertEquals("API请求失败", 200, response.getHttpStatus());
		assertEquals(response.getErrMsg(), 0, response.getErrCode());
	}
	
	protected byte[] toByteArray(InputStream input) throws IOException {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[4096];
	    int n = 0;
	    while (-1 != (n = input.read(buffer))) {
	        output.write(buffer, 0, n);
	    }
	    return output.toByteArray();
	}
}
