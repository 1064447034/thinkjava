/**
 * Creation Date:2017年12月12日-上午10:58:42
 * 
 * Copyright 2008-2016 © 同程网 Inc. All Rights Reserved
 */
package com.ly.study.thinkjava.webdriver;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;

public class FetchLoginCaptchaZHPC {
	public byte[] fetchCaptcha (HttpClient httpClient, String loginCaptchaUrl, String cookie, String orderNo) throws Exception {
		byte[] responseData = null;

		loginCaptchaUrl = loginCaptchaUrl + "?t=0." + generateMixString(16);
		Map<String, String> requestHeader = new HashMap<>();
		requestHeader.put("Cookie", cookie);
		requestHeader.put("Host", "www.shenzhenair.com");
		requestHeader.put("Referer", "http://www.shenzhenair.com/");
		requestHeader.put("Connection", "keep-alive");
		requestHeader.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		requestHeader.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
		requestHeader.put("Accept-Encoding", "gzip, deflate");
		requestHeader.put("Accept-Language", "zh-CN,zh;q=0.9");

		HttpContext response = HttpClientUtil.doGetNoRedirect(httpClient, loginCaptchaUrl, new HashMap<String, Object>(), requestHeader);
		int httpStatus = HttpClientUtil.getResponseCode(response.getResponse());
		if (httpStatus == HttpStatus.SC_OK) {
			responseData = HttpClientUtil.getResponseContentBytes(response);
		}
		return responseData;
	}
	
	public static String generateMixString(int length) {
		String LETTERCHAR = "0123456789";
        StringBuffer sb = new StringBuffer();  
        Random random = new Random();  
        for (int i = 0; i < length; i++) {  
            sb.append(random.nextInt(LETTERCHAR.length()));  
        }  
        return sb.toString();  
    }
	
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = HttpClientUtil.getHttpClientWithProxy("10.100.157.242:8087:zbs39170:3789625", 10, 20);
//		HttpClient httpClient = HttpClientUtil.getDefaultHttpClient();
		FetchLoginCaptchaZHPC fetch = new FetchLoginCaptchaZHPC();

//		String cookie = "sign_cookie=c5d737640a6ec9940a61ceb1c02dc93f; sign_flight=19790b9b85ded6a8e11732b285e8c6a6";
		String cookie = "sign_cookie=59c4ace2fc5339104625275e86f69ff3; sajssdk_2015_cross_new_user=1; sign_flight=3ae43f02c11606e2252b0106c84536b8; AlteonP=AhdFAm9ADgrXNbtQ5bxHcQ$$; _g_sign=b36e32b22113bb8a2a1d69261d4554b9; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2216155684135329-0273096c2fc259-3e3d5307-2073600-161556841365cf%22%2C%22%24device_id%22%3A%2216155684135329-0273096c2fc259-3e3d5307-2073600-161556841365cf%22%7D; CoreSessionId=25aac4af5a07b5f9421dcff6273b5afc3941f4c242800941; ";
		String loginCaptchaUrl = "http://www.shenzhenair.com/szair_B2C/getLoginCaptcha.action";
		
		for (int i = 0; i < 10; ++i) {
			byte[] result = fetch.fetchCaptcha(httpClient, loginCaptchaUrl, cookie, "");

			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\zh\\" + String.valueOf(i) + ".png"));
			bos.write(result);
			bos.close();
		}
	}
	
}