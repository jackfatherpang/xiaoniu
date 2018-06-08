package com.pool;

import org.apache.commons.dbutils.QueryRunner;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据库连接池的使用
 * @author pang
 *
 */
public class Dbconnectionpool2 {
	public static void main(String[] args) throws Exception {
		//创建连接池对象
		ComboPooledDataSource ds = new ComboPooledDataSource();
		String sql ="insert into products values(null,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(ds);
		//增删改都是update()，查询是query()
//		List<Products> list = runner.query(sql, new BeanListHandler<Products>(Products.class));
//		System.out.println(list);
		//多行数据用beanlisthandler,一行数据用beanhandler
//		Products products = runner.query(sql, new BeanHandler<Products>(Products.class), 2);
//		System.out.println(products);
		 int update = runner.update(sql, "未来的道路跪着也要走完",100,"必修课",10,"论程序员的自我修养");
		System.out.println(update);
	}
}
