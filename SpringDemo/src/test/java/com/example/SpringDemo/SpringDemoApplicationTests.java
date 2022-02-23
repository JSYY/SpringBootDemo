package com.example.SpringDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringDemoApplicationTests {
	//数据源组件
	@Autowired
	DataSource dataSource;
	//用于访问数据库的组件
	@Autowired
	JdbcTemplate jdbcTemplate;
	//数据库连接测试
	@Test
	void contextLoads() throws SQLException {
		System.out.println("默认数据源为：" + dataSource.getClass());
		System.out.println("数据库连接实例：" + dataSource.getConnection());
		//访问数据库
		Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `person`", Integer.class);
		System.out.println("person 表中共有" + i + "条数据。");
	}

}
