package com.ly.study.thinkjava;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal marketFee = new BigDecimal("1750");
        String choseFlightShow = "【深圳航空】尊敬的旅客，您的深航手机验证码为：960537，您正在使用深航航空机票预订功能，验证码有效期为2分钟";
        if (!StringUtils.isEmpty(choseFlightShow)) {	// 会员再享97折
        	Pattern p = Pattern.compile("\\d+");
    		Matcher m = p.matcher(choseFlightShow);
    		if (m.find()) {
    			System.out.println(m.group());
    			System.out.println(m.group(0));
    			String discountStr = m.group();	// 97
    			if (!StringUtils.isEmpty(discountStr)) {
    				BigDecimal discount = new BigDecimal(discountStr);
    				BigDecimal discountAmount = marketFee.multiply(new BigDecimal(100).subtract(discount).divide(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_DOWN);
    				if (discountAmount.compareTo(BigDecimal.TEN) > 0) {
    					discountAmount = discountAmount.divide(BigDecimal.TEN).setScale(0, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.TEN);
    					System.out.println(discountAmount);
    				}
    			}
    		}
    	}
	}

}
