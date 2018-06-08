package com.test;
/**
 * 1、注册驱动
 * 2、建立连接
 * 3、获取执行sql语句的对象
 * 4、执行sql语句，如果是查询返回结果集
 * 5、释放资源
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Demo {
	public static void main(String[] args) throws Exception {
		//注册驱动
//		DriverManager.registerDriver(new Driver());
//		new Driver();
		Class.forName("com.mysql.jdbc.Driver");//解决两次注册问题的方法
		//创建建立连接的对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pang", "root", "root");
		//创建执行sql语句的对象
		Statement st = conn.createStatement();
		String sql ="select * from products";
//		int i =1/0;会造成该程序执行一半，后面的关闭资源无法进行
		//执行sql语句
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			String string = rs.getString(1);
			System.out.println(string);
		}
		//关闭资源
		rs.close();
		st.close();
		conn.close();
	}
}
