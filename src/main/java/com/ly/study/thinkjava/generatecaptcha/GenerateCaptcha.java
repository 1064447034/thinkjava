package com.ly.study.thinkjava.generatecaptcha;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.http.client.HttpClient;

public class GenerateCaptcha {
	private static String dir = "e:/aq/";
	public static void main(String[] args) throws Exception {
		String captchaUrl = "http://www.9air.com/aq/ValidateCode?timestamp=" + System.currentTimeMillis();
//		String captchaUrl= "http://www.shenzhenair.com/szair_B2C/getLoginCaptcha.action?t=0.2521793386265192";
		
		HttpClient httpClient = HttpClientUtil.getHttpClientWithProxy("10.100.157.242:8087:zbs39170:3789625", 10,20);
//		HttpClient httpClient = HttpClientUtil.getDefaultHttpClient();
		for (int i = 50; i < 10000; ++i) {
			HttpContext response = HttpClientUtil.doGet(httpClient, captchaUrl);
			int httpStatus = HttpClientUtil.getResponseCode(response.getResponse());
			if (httpStatus == 200) {
				if (!new File(dir).exists()) {
					new File(dir).mkdirs();
				}
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\aq\\" + String.valueOf(i) + ".png"));
				bos.write(HttpClientUtil.getResponseContentBytes(response));
				bos.close();
			}
		}
	}
}
