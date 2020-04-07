/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.mobaas.wxapi.request.MenuGetRequest;
import com.mobaas.wxapi.response.MenuGetResponse;

public class MenuTest extends BaseTest {

	@Test
	public void testMenuGet() throws IOException {
		MenuGetRequest request = new MenuGetRequest();
		MenuGetResponse response = apiClient.execute(request);
		
		assertResponse(response);
		
		assertNotNull(response.getCustomMenu());
		assertNotNull(response.getCustomMenu().getItemList());
		
		assertTrue(response.getCustomMenu().getItemList().size() > 0);
	}

}
