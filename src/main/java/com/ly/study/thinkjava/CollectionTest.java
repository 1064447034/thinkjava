package com.ly.study.thinkjava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class CollectionTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");  
		list.stream().forEach(e ->{
		    if(e.length() >= 5){  
		        return;  
		    }  
		    System.out.println(e);  
		});
//		HttpMessageConverter
//		RequestMappingHandlerAdapter
//		FastJsonHttpMessageConverter
		
		AA a = new AA();
		BB b = new BB();
		AA ab = new BB();
		
		System.out.println(b instanceof BB);
		System.out.println(b instanceof AA);
		System.out.println(a instanceof AA);
		System.out.println(a instanceof BB);
		System.out.println(ab instanceof AA);
		System.out.println(ab instanceof BB);
		
		System.out.println(AA.class.isInstance(a));
		System.out.println(AA.class.isInstance(b));
		System.out.println(AA.class.isInstance(ab));
		System.out.println(BB.class.isInstance(a));
		System.out.println(BB.class.isInstance(b));
		
		Map<String, String> map = new HashMap<>();
		map.put("aa", "aa");
		map.put("bb", "bb");
		map.put("cc", "cc");
		System.out.println(JSON.toJSONString(map));
	}
}

class AA {
	
}

class BB extends AA {
	
}