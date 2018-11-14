package com.ly.study.thinkjava.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

public class Http {
	public static void main(String[] args) {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        response.addHeader("Set-Cookie", "JSESSIONID=7170C2D8B3F266762434F0068840F94C; Path=/h5/; HttpOnly ");
        response.addHeader("Set-Cookie", "CUA_SSO_TOKEN=32be0952-c4be-4718-910f-55f641a49f58; Domain=.flycua.com; ");
        response.addHeader("Set-Cookie", "xxx_TEN=32be0952-c4be-4718-910f-55f641a49f58; Domain=.flycua.com; ");

//        System.out.println(response.getFirstHeader("cookie1"));
//        System.out.println(response.getLastHeader("cookie2"));
//        System.out.println("---------------------------------------------");

//        Header[] heads = response.getHeaders("cookie1");
//        for(Header head : heads)
//            System.out.println(head);
//        System.out.println("---------------------------------------------");
        
//        HeaderIterator it = response.headerIterator();
//        while(it.hasNext())
//            System.out.println(it.next());
//        System.out.println("---------------------------------------------");
/*
        HeaderElementIterator hei = new BasicHeaderElementIterator(response.headerIterator());
        while(hei.hasNext()) {
            HeaderElement element = hei.nextElement();
            System.out.println(element.getName() + "=" + element.getValue());
            NameValuePair[] params = element.getParameters();
            for(NameValuePair name : params)
                System.out.println(name);
        }
*/
//        System.out.println(response.getFirstHeader("cookie1").getName());
//        System.out.println(response.getFirstHeader("cookie1").getValue());
//        System.out.println(response.getFirstHeader("cookie1").getElements()[0].getName());
//        System.out.println(response.getFirstHeader("cookie1").getElements()[0].getValue());
//        System.out.println(response.getFirstHeader("cookie1").getElements()[0].getParameterCount());
////      System.out.println(response.getFirstHeader("cookie1").getElements()[0].getParameters());
//        System.out.println(response.getFirstHeader("cookie1").getElements()[0].getParameters()[0].getName());
//        System.out.println(response.getFirstHeader("cookie1").getElements()[0].getParameters()[0].getValue());
//        
       String result = "";
       Header[] headers = response.getHeaders("Set-Cookie");
       System.out.println(response);
       for (Header item : headers) {
//    	   System.out.println(item.getName());
//    	   System.out.println(item.getValue());

	    	 result += StringUtils.trim(item.getValue());
	    	 System.out.println(result.charAt(result.length() - 1));
	    	 if (result.charAt(result.length() - 1) != ';') {
	    		 result += ";";
	    	 }    	   
    	   HeaderElement[] elements = item.getElements();
    	   for (HeaderElement element : elements) {
//    		   if (element.getName().equals("JSESSIONID")) {
//        		   System.out.println(element.getValue());    			   
//    		   }
//    		   if (element.getName().equals("CUA_SSO_TOKEN")) {
//    			   System.out.println(element.getValue());
//    		   }
//    		   NameValuePair[] pairs = element.getParameters();
//    		   for (NameValuePair pair : pairs) {
//    			   System.out.println(pair);
//    		   }
    	   }
       }
       System.out.println(result);
    }
}
