package com.ly.study.thinkjava;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class FormatTest {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ParseException {	
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hl15995721676".getBytes());
//		System.out.println(new BigInteger(1,b).toString(16).toUpperCase());
		String s = new BigInteger(1, md.digest()).toString(16).toUpperCase();
		DataOutputStream bw = new DataOutputStream(new FileOutputStream("e:\\a.txt"));
		bw.writeUTF(s);
		bw.close();
/*
		String s = new BigInteger(1, "FBBC07F3BDE132959908B4CC9182B67D".getBytes()).toString(16).toUpperCase();
		DataOutputStream bw = new DataOutputStream(new FileOutputStream("e:\\a.txt"));
		bw.writeUTF(s);
		bw.close();
*/
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.getSecond());
		
	}
}
