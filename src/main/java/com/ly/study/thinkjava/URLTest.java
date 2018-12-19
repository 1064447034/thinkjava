package com.ly.study.thinkjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws IOException, URISyntaxException {
		String str = "http://www.example.com/";
		URL url = new URL(str);
		System.out.println(url.getHost());
		System.out.println(url.toExternalForm()); 
		System.out.println(url.toURI());
		System.out.println(url.getFile());
		System.out.println(url.getDefaultPort());
		System.out.println(url.getPath());
		System.out.println("port: " + url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getQuery());
		System.out.println(url.getRef());
		System.out.println(url.getUserInfo());
		System.out.println(url.toExternalForm());
		System.out.println("toString: " + url.toString());
		
		
		Object obj = url.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
//		String s = "";
//		while ((s = br.readLine()) != null) {
//			System.out.println(s);
//		}
	
		URL url2 = new URL("http://www.example.com");
		HttpURLConnection connect = (HttpURLConnection)url2.openConnection();
		connect.setDoOutput(true);
		connect.setDoInput(true);
		connect.setUseCaches(false);
		connect.setRequestProperty("Connection", "Keep-alive");
		connect.setRequestMethod("GET");
		connect.connect();
		Object obj2 = connect.getContent();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(connect.getInputStream()));
//		BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
		String s2 = "";
		while ((s2 = br.readLine()) != null) {
			System.out.println(s2);
		}
	}
}
