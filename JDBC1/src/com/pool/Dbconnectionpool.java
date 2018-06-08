package com.pool;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pojo.Products;
/**
 * 数据库连接池的使用
 * @author pang
 *
 */
public class Dbconnectionpool {
	public static void main(String[] args) throws Exception {
		
		ComboPooledDataSource ds = new ComboPooledDataSource();
		String sql ="select * from products";
		QueryRunner runner = new QueryRunner(ds);
		List<Products> list = runner.query(sql, new BeanListHandler<Products>(Products.class));
		System.out.println(list);
	}
}
