package com.ly.study.thinkjava;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class OriginBase64 {

	public static void main(String[] args) {
		String asB64 = Base64.getEncoder().encodeToString("subjects?abcd".getBytes());
		System.out.println(asB64);

		String toStr = new String(Base64.getDecoder().decode(asB64));
		System.out.println(toStr);
		
		String urlB64 = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes());
		System.out.println(urlB64);
		
		String toUrl = new String(Base64.getUrlDecoder().decode(urlB64));
		System.out.println(toUrl);
		
		String uuids = "";
		for (int i = 0; i < 10; ++i) {
			uuids += UUID.randomUUID().toString();
		}
		String mimeB64 = Base64.getMimeEncoder().encodeToString(uuids.getBytes());
		System.out.println(mimeB64);
		
		String toMime = new String(Base64.getMimeDecoder().decode(mimeB64));
		System.out.println(toMime);
		
		Date d = new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
	}

}
