package com.xiaoniu.IpBelonging;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IpUtils {
	static  List<IpBean> beanlist = null;
	static{
		beanlist = LoadIpData();
		
		
	}
	public static void main(String[] args) {
		LoadIpData();
	}
	
	public static long strIpToLong(String str){
		if(str==null){
			return 0L;
		}
		
		Long newIp =0L;
		String[] split = str.split("\\.");
		for(int i =0;i<=3;i++){
			Long lL = Long.parseLong(split[i]);
			newIp |= lL<<((3-i)<<3);
			
		}
		
		return newIp;
		
	}
	
	public static List<IpBean> LoadIpData(){
		List<IpBean> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("e://ip.txt"));){
			String line = null;
			while((line=br.readLine())!=null){
//				System.out.println(line);
				String[] split = line.split("\\|");
				//1.10.16.0|1.10.127.255|17436672|17465343|亚洲|中国|广东|广州||电信|440100178
				String startIp = split[0];
				String endIp= split[1];
				long startDecIp = Long.parseLong(split[2]);
				long endDecIp = Long.parseLong(split[3]);
				String province = split[6];
				String city = split[7];
				String operator = split[9];
				IpBean bean = new IpBean();
				bean.set(startIp, endIp, startDecIp, endDecIp, province, city, operator);
				list.add(bean);
			}
			System.out.println(list.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static IpBean getIpBeanByIpNew(long longIp){
		int start =0;
		int end =beanlist.size()-1;
		while(start<=end){
			int mid =(start+end)/2;
			IpBean ipBean = beanlist.get(mid);//找到索引是中间值的ipBean
			if(longIp>=ipBean.getStartDecIp() && longIp<=ipBean.getEndDecIp()){
				return ipBean;
			} else{
				if(longIp<ipBean.getStartDecIp()){
					end =mid-1;
				}
				if(longIp>ipBean.getEndDecIp()){
					start =mid+1;
				}
			}
			
		}
		return null;
		
	}

}
