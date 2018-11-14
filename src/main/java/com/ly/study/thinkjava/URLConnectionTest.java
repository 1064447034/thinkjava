package com.ly.study.thinkjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
		System.setProperty("http.proxyHost", "localhost");
		System.setProperty("http.proxyPort", "8888");
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://www.163.com/");
			conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(false);
			conn.setRequestMethod("GET");
			conn.connect();
			
			InputStream in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("错误响应吗：" + conn.getResponseCode());
			}
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
