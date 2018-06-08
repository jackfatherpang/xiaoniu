package com.xiaoniu.NetReptile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainTest {

	public static void main(String[] args) throws Exception {
		String url = "https://search.51job.com/list/010000,000000,0000,00,9,99,%25E5%25A4%25A7%25E6%2595%25B0%25E6%258D%25AE%25E5%25BC%2580%25E5%258F%2591%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,1.html?lang=c&amp;stype=&amp;postchannel=0000&amp;workyear=99&amp;cotype=99&amp;degreefrom=99&amp;jobterm=99&amp;companysize=99&amp;providesalary=99&amp;lonlat=0%2C0&amp;radius=-1&amp;ord_field=0&amp;confirmdate=9&amp;fromType=&amp;dibiaoid=0&amp;address=&amp;line=&amp;specialarea=00&amp;from=&amp;welfare=";
		Document doc = getDocument();
		Page page = new Page();
		page.setDocument(doc);
		int count =0;
		while(true){
			System.out.println("第"+(++count)+"次");
			List<Job> jobByPage = getJobByPage(page);
//			System.out.println(page);
			for (Job job : jobByPage) {
//				System.out.println(job);
			}
			getNextPageUrl(page);
			if(page.isHasNextPage()){
				doc = getDocument();
				page.setDocument(doc);
			} else{
				break;
			}
			
		}
		
	}

	private static void getNextPageUrl(Page page) {
		Document document = page.getDocument();
//		System.out.println(document);
		Elements select = document.select(".bk");
//		System.out.println(select+"-----");
		Element element2 = select.get(1);
	
		Elements select2 = element2.select("a");
		if (select2 != null && select2.size() > 0) {
			String addr = select2.get(0).attr("href");
			page.setNextPageUrl(addr);
			page.setHasNextPage(true);
		} else {
			page.setHasNextPage(false);
		}
	}

	public static List<Job> getJobByPage(Page page) {
		Document doc = page.getDocument();
		Elements select = doc.select("#resultList .el");
		System.out.println(select);
		select.remove(0);
		ArrayList<Job> list = new ArrayList<Job>();
		for (Element element : select) {
			Elements select2 = element.select(".t1 a");
			Element jobelement = select2.get(0);
			String jobname = jobelement.attr("title");
			Elements select3 = element.select(".t2 a");
			Element cmpelement = select3.get(0);
			String cmpname = cmpelement.attr("title");
			Elements select4 = element.select(".t3");
			Element addrelement = select4.get(0);
			String addr = addrelement.text();
			Elements select5 = element.select(".t4");
			Element salarylement = select5.get(0);
			String salary = salarylement.text();
			Elements select6 = element.select(".t5");
			Element datelement = select6.get(0);
			String date = datelement.text();
			Job job = new Job();
			job.set(cmpname, jobname, addr, salary, date);
			list.add(job);
			
			
		}

		return list;
	}

//	public static Document getDocumentByUrl(String url) {
//		Document doc = Jsoup.parse(url);
//
//		return doc;
//
//	}
	public static Document getDocument() throws Exception{
		String url = "https://search.51job.com/list/010000,000000,0000,00,9,99,%25E5%25A4%25A7%25E6%2595%25B0%25E6%258D%25AE%25E5%25BC%2580%25E5%258F%2591%25E5%25B7%25A5%25E7%25A8%258B%25E5%25B8%2588,2,1.html?lang=c&amp;stype=&amp;postchannel=0000&amp;workyear=99&amp;cotype=99&amp;degreefrom=99&amp;jobterm=99&amp;companysize=99&amp;providesalary=99&amp;lonlat=0%2C0&amp;radius=-1&amp;ord_field=0&amp;confirmdate=9&amp;fromType=&amp;dibiaoid=0&amp;address=&amp;line=&amp;specialarea=00&amp;from=&amp;welfare=";
		URL ur = new URL(url);
		Document document = Jsoup.parse(url);
		return document;
		
	}

}
