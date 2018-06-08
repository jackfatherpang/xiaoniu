package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pojo.Products;

public class Demo2 {
	static String property2 = null;
	static String property3 = null;
	static String property4 = null;
	static {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("config/db.properties"));
			Properties p = new Properties();
			p.load(inputStream);//加载配置文件
			String classname = p.getProperty("className");
			property2 = p.getProperty("url");
			property3 = p.getProperty("userName");
			property4 = p.getProperty("passWord");
			Class.forName(classname);//注册驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//上面在静态代码块中读取配置文件

	public static void main(String[] args) {
		Connection conn=null ;
		Statement st=null ;
		ResultSet rs = null;
		try {
			
			 conn = DriverManager.getConnection(property2, property3, property4);

			 st = conn.createStatement();
			String sql = "select * from products";
			 rs = st.executeQuery(sql);
			 List<Products> list = new ArrayList<>();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String category = rs.getString(4);
				String pnum = rs.getString(5);
				String description = rs.getString(6);
				Products p = new Products(Integer.parseInt(id), name, price, category, pnum, description);
				 list.add(p);
			}
			System.out.println(list.size());
			 //增
//			 String sql ="insert into products values(12,'小黑鱼凤姐的爱情故事',100,'惊悚',40,'欲罢不能')";
//			 int e = st.executeUpdate(sql);
//			 System.out.println(e);
			 //删除
//			 String sql ="delete from products where id=11";
//			 int i = st.executeUpdate(sql);
//			 System.out.println(i);
			 //修改
//			 String sql ="update products set name='duzhe',category='keji'where id=12";
//			 int i = st.executeUpdate(sql);
//			 System.out.println(i);
			 //查询
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
					if(st!=null){
						st.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
