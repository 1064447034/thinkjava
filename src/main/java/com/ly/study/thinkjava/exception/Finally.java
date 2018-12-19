package com.ly.study.thinkjava.exception;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class Finally {
	public static void main(String[] args) {
//		try {
//			devide();
//		} catch (Exception e) {
//			System.out.println("exception");
//			e.printStackTrace();
//		}
		try {
			java7try();
		} catch (Exception e) {
			System.out.println("java7 exception");
			e.printStackTrace();
		}
	}
	
	private static int devide() {
		try {
			return 1/2;
		} finally {
			try {
				System.out.println(1/0);				
			} catch (Exception e) {
				System.out.println("devide by zero");
			}
		}
	}
	private static int java7try() {
		try(CloseableHttpClient httpClient = getHttpClient()) {
			HttpGet httpGet = new HttpGet("http://www.baidu.com");
//			httpClient.execute(httpGet);
			return 1 / 0;
		} catch (Exception e) {
			System.out.println("exce");
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
		return 0;
	}
	
	private static CloseableHttpClient getHttpClient() {
		return null;
	}
}
