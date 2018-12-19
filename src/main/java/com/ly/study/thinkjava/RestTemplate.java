package com.ly.study.thinkjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RestTemplate {
	public static void main(String[] args) {
		try {
			InetAddress inet = getLocalHostLANAddress();
			System.out.println(inet.getHostAddress());
			System.out.println(inet.getHostName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getOrderSMSNumberAQ(String msgCode) {
		
		if (!msgCode.contains("验证码为")) {
			return "";
		}
		//短信呼转来自10690302666628：【中国联航】亲~ 您的验证码为：8358
		msgCode = msgCode.split("验证码为")[1];
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(msgCode);  
		return m.replaceAll("").trim();
	}
	
	public static void parsePage() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D:\\MyConfiguration\\zbs39170\\Desktop\\order.txt"));
		String page = "";
		String line;
		while ( (line = br.readLine()) != null) {
			page += line;
		}
		String orderNo = StringUtils.substringBetween(page, "<li><strong>订单编号：</strong>", "</li>");
		String amountStr = StringUtils.substringBetween(page, "支付总额：", "</span>");
		String amount = StringUtils.substringAfter(amountStr, "￥"); 
		System.out.println(orderNo);
		System.out.println(amount);
	}
	
	public static void getJSWTFPCParam() {
		String channel = "";
		channel = StringUtils.isEmpty(channel) ? "app" : channel;
		System.out.println(channel);
	}
	
	private static String getMACAddress()throws Exception{    
        //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。    
		InetAddress ia = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();    
            
        //下面代码是把mac地址拼装成String    
        StringBuffer sb = new StringBuffer();    
            
        for(int i=0;i<mac.length;i++){    
            if(i!=0){    
                sb.append("-");    
            }    
            //mac[i] & 0xFF 是为了把byte转化为正整数    
            String s = Integer.toHexString(mac[i] & 0xFF);    
            System.out.println("--------------");  
            System.err.println(s);  
              
            sb.append(s.length()==1?0+s:s);    
        }    
            
        //把字符串所有小写字母改为大写成为正规的mac地址并返回    
        return sb.toString().toUpperCase();    
    }
	public static InetAddress getLocalHostLANAddress() throws Exception {
	    try {
	        InetAddress candidateAddress = null;
	        // 遍历所有的网络接口
	        for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
	            NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
	            // 在所有的接口下再遍历IP
	            for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
	                InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
	                if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
	                    if (inetAddr.isSiteLocalAddress()) {
	                        // 如果是site-local地址，就是它了
	                        return inetAddr;
	                    } else if (candidateAddress == null) {
	                        // site-local类型的地址未被发现，先记录候选地址
	                        candidateAddress = inetAddr;
	                    }
	                }
	            }
	        }
	        if (candidateAddress != null) {
	            return candidateAddress;
	        }
	        // 如果没有发现 non-loopback地址.只能用最次选的方案
	        InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
	        return jdkSuppliedAddress;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
