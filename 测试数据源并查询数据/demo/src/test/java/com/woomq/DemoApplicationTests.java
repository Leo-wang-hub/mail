package com.woomq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired(required = false)
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		//查看数据源
		System.out.println(dataSource.getClass());
		//获得数据库连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		//关闭连接
		connection.close();

	}

}
