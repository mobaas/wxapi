/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Api响应基类
 * @author billy
 *
 */
public class WxApiResponse {

	private int httpStatus;
	private String content;
	private int errCode;
	private String errMsg;
	private Exception exception;
    private HashMap dataMap;
    
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getErrCode() {
		return errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public <T> T getValue(String key) {
        if (dataMap.containsKey(key))
            return (T)dataMap.get(key);

        return null;
    }
	
	public void parse() throws IOException {
		if (!StringUtils.isEmpty(getContent()))  {
	       	 ObjectMapper mapper = new ObjectMapper();
	       	 
	       	dataMap = mapper.readValue(getContent(), HashMap.class);
            if (!dataMap.containsKey("errcode")) {
                errCode = 0;
            } else {
                errCode = (Integer)dataMap.get("errcode");
                errMsg = (String)dataMap.get("errmsg");
            }
        } else {
        		dataMap = new HashMap();
        }
	}
	
	public boolean isSuccess() {
		return httpStatus == 200 && errCode == 0;
	}
}
