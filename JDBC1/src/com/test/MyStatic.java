package com.test;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MyStatic {
	static{
		try {
	//存在两次注册问题public class com.mysql.jdbc.Driver extends com.mysql.jdbc.NonRegisteringDriver implements java.sql.Driver
			DriverManager.registerDriver(new Driver());
			System.out.println("帅哥最爱玛丽苏。。");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
