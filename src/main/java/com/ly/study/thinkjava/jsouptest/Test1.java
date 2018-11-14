package com.ly.study.thinkjava.jsouptest;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test1 {
	public static void main(String[] args) throws IOException {
		Document doc1 = Jsoup.connect("http://www.oschina.net/").
				data("query", "Java")
				.userAgent("I'm joup")
				.cookie("auth", "token")
				.timeout(3000)
				.post();

		String html = "<html><head><title ref=\"111.html\"> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
		Document doc3 = Jsoup.parse(html);
		Elements elements = doc3.getElementsByAttribute("ref");
		System.out.println(elements);
		System.out.println(elements.attr("ref"));
		
		
//		Document doc6 = Jsoup.parse(new URL("http://example.com/"), 1000);
//		System.out.println(doc6);
//		System.out.println(doc6.getElementsByTag("p"));

//		System.out.println();
//		System.out.println("doc7: ");
//		Document doc7 = Jsoup.parse("", "");
//		System.out.println(doc7);
//		System.out.println(doc7.baseUri());
//		
//		Document doc5 = Jsoup.connect("http://example.com/").get();
//		System.out.println(doc5.absUrl("herf"));
//		
//		File input2 = new File("/tmp/input.html");
//		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//		Elements content = doc.getElementsByTag("h1");
//		System.out.println(content);
//		
//		String s = " <div id=\"imgDiv\" class=\"imgClass\">   <a href=\"#\">     <img src=\"http://xxxx.xx/xx.jpg\"/>   </a>   </div>";
//		Document doc8 = Jsoup.parse(s);
//		Elements content2 = doc8.getElementsByTag("div");
//		System.out.println(content2);
		
		Document doc6 = Jsoup.parse(new URL("http://example.com/"), 1000);
		Elements links = doc6.select("a[href]");
		System.out.println(links);
	}

}
