package com.xiaoniu.NetReptile;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

public class TestJsoup {
	static Document doc =null;
	
	
	public static void main(String[] args) {
		
	}
	
	@Test
	public void getContent(){
		//<span class="list" height="18">简</span>
		Elements select = doc.select("#resultList .el .t2 a");
		for (Element element : select) {
			element.parent();
			element.children();
			element.nextSibling();
			element.siblingElements();
			element.previousElementSibling();
			System.out.println(element.text());
			System.out.println(element.attr("href"));
			System.out.println("**************************");
		}
		
	}
	
	@Test
	public void getDocumentCh() throws Exception{
		
		Element elementById = doc.getElementById("languagelist");

		Elements elementsByClass = doc.getElementsByClass("el");
	
		Elements elementsByTag = doc.getElementsByTag("body");
		
		Element element = elementsByTag.get(0);
		Elements select = doc.select("body #languagelist .tle");
		
	
		
		
	}
	
	@Before
	public void getDocument() throws IOException{
		
		String jburl = "https://search.51job.com/list/010000,000000,0000,00,9,99,%25E5%25A4%25A7%25E6%2595%25B0%25E6%258D%25AE%25E5%25BC%2580%25E5%258F%2591%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,1.html?lang=c&amp;stype=&amp;postchannel=0000&amp;workyear=99&amp;cotype=99&amp;degreefrom=99&amp;jobterm=99&amp;companysize=99&amp;providesalary=99&amp;lonlat=0%2C0&amp;radius=-1&amp;ord_field=0&amp;confirmdate=9&amp;fromType=&amp;dibiaoid=0&amp;address=&amp;line=&amp;specialarea=00&amp;from=&amp;welfare=";
		URL url = new URL(jburl);
		
		doc = Jsoup.parse(url, 4000);
		System.out.println(doc);
		
		
	}
	
		
		
		
	}
	
	
	
	


