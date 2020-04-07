/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

/**
 * WxApiException
 * @author billy
 *
 */
public class WxApiException extends Exception {
	
	public WxApiException(String message) {
        super(message);
    }

    public WxApiException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public WxApiException(Throwable cause) {
        super(cause);
    }
}
