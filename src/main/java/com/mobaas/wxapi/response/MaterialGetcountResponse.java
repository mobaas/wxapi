/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi.response;

import java.io.IOException;

import com.mobaas.wxapi.WxApiResponse;

public class MaterialGetcountResponse extends WxApiResponse {

	private int videoCount;
	private int voiceCount;
	private int imageCount;
	private int newsCount;
	
	public int getVideoCount() { return videoCount; }
	
	public int getVoiceCount() { return voiceCount; }

	public int getImageCount() { return imageCount; }
	
	public int getNewsCount() { return newsCount; }
	
	@Override
	public void parse() throws IOException {
		super.parse();
		
		videoCount = getValue("video_count");
		voiceCount = getValue("voice_count");
		imageCount = getValue("image_count");
		newsCount = getValue("news_count");
	}
}
