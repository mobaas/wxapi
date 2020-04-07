/*******************************************************
 * Copyright 2015 mobaas
 * http://blog.mobaas.com/
 * 
 * --- wxapi
 * 
 ********************************************************/

package com.mobaas.wxapi;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import com.mobaas.wxapi.request.TokenRequest;
import com.mobaas.wxapi.response.TokenResponse;

/**
 * WxApiClient
 * @author billy
 *
 */
public class WxApiClient {

	private static String API_PREFIX = "https://api.weixin.qq.com/cgi-bin/";
     
	private static final int connectTimeout = 5000;  // 5秒
	private static final int socketTimeout = 5000;  // 5秒
	
	 public static WxApiClient create(String appId, String appSecret) {
		 WxApiClient client = new WxApiClient();
         client.setAppId( appId );
         client.setAppSecret( appSecret );
         
         return client;
     } 

	 private String appId;
	 private String appSecret;
	 
	 private WxApiClient() {
		 
	 }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	 
	public <T extends WxApiResponse> T execute(WxApiRequest<T> request) throws IOException {

        WxApiResponse resp = request.createResponse();
        
		TokenResponse tokenResp = getAccessToken(); // 获取失败。
		if (!tokenResp.tokenIsValid()) {
			resp.setHttpStatus(tokenResp.getHttpStatus());
			resp.setContent(tokenResp.getContent());
			resp.setException(tokenResp.getException());
			resp.parse();
            return (T)resp;
		}
		
		 String url = API_PREFIX + request.getAction();
			
		 if (url.indexOf("?") > 0)
			 url += "&access_token=" + tokenResp.getAccessToken();
		 else
			 url += "?access_token=" + tokenResp.getAccessToken();

		 try {
			 CloseableHttpResponse response = execute(request.getRequest(url));
			 resp.setHttpStatus(response.getStatusLine().getStatusCode());
			 if (resp.getHttpStatus() == 200) {
				 resp.setContent(EntityUtils.toString(response.getEntity(), "utf-8"));
				 resp.parse();
			 }
		 } catch (IOException ex) {
			 resp.setHttpStatus(599);
		 }
		 
	     return (T)resp;
	}
	
     private TokenResponse tokenResp;
     
     private TokenResponse getAccessToken() throws IOException {
    	 
    	 if (tokenResp == null || 
    			 tokenResp.getHttpStatus() != 200 ||
    			 tokenResp.getErrCode() != 0 ||
    			 tokenResp.tokenIsExpires()) {
	    	 TokenRequest request = new TokenRequest();
	    	 request.setAppId(appId);
	    	 request.setAppSecret(appSecret);
	    	 
	    	 tokenResp = request.createResponse();
			 try {
				 String url = API_PREFIX + request.getAction();
				 CloseableHttpResponse response = execute(request.getRequest(url));
				 tokenResp.setHttpStatus(response.getStatusLine().getStatusCode());
				 if (tokenResp.getHttpStatus() == 200) {
					 tokenResp.setContent(EntityUtils.toString(response.getEntity(), "utf-8"));
					 tokenResp.parse();
				 }
			 } catch (IOException ex) {
				 tokenResp.setHttpStatus(599);
				 tokenResp.setException(ex);
			 }
    	 }

         return tokenResp;
     }

     private RequestConfig getRequestConfig() {
 		return RequestConfig.custom()
     			.setConnectTimeout(connectTimeout)
     			.setSocketTimeout(socketTimeout)
     			.build();
 	}
 	
     private SSLConnectionSocketFactory socketFactory;
     private PoolingHttpClientConnectionManager connectionManager;
     
     private SSLConnectionSocketFactory getSocketFactory() {
	    	 if (socketFactory != null)
	    		 return socketFactory;
    	 
    	 	try {
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {

				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			
			socketFactory = new SSLConnectionSocketFactory(sslContext, 
					new String[] {"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, 
					null, 
					NoopHostnameVerifier.INSTANCE);
			
			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", new PlainConnectionSocketFactory())
					.register("https", socketFactory)
					.build();
			
			connectionManager = new PoolingHttpClientConnectionManager(registry);
			connectionManager.setMaxTotal(100);
			
			return socketFactory;
			
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
        
    	 	return null;
     }
     
 	private CloseableHttpResponse execute(HttpUriRequest request) throws IOException {

     	CloseableHttpClient client = HttpClients.custom()
     			.setDefaultRequestConfig(getRequestConfig())
     			.setSSLSocketFactory(getSocketFactory())
     			.setConnectionManager(connectionManager)
     			.setConnectionManagerShared(true)
     			.build();
     	
 	    try {
 	    		return client.execute(request);
 	    } finally {
 	    		try {
 				client.close();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 	    }
 	}
}
