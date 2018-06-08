package com.xiaoniu.IpBelonging;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Testmain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		List<Entry<String, Integer>> list = null;
		try (BufferedReader br = new BufferedReader(new FileReader("e://access.log"));) {

			String str = null;
			while ((str = br.readLine()) != null) {
				// System.out.println(str);
				String strIp = str.split("\\|")[1];
				long longIp = IpUtils.strIpToLong(strIp);
				IpBean ipBean = IpUtils.getIpBeanByIpNew(longIp);
				String province = ipBean.getProvince();
				Integer count = map.getOrDefault(province, 0);
				count++;
				map.put(province, count);

				// System.out.println(map);
				Set<Entry<String, Integer>> entrySet = map.entrySet();
				list = new ArrayList<>(entrySet);

				Collections.sort(list, new Comparator<Entry<String, Integer>>() {

					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

						return o1.getValue() - o2.getValue();
					}
				});
				// System.out.println(entry.getKey()+":"+entry.getValue());

			}
			for (Entry<String, Integer> netry : list) {
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
