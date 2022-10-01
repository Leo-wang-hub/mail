package com.woomq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class MailApplicationTests {
	@Autowired(required = false)
	DataSource source;
	@Test
	void contextLoads() {
		System.out.println(source.getClass());
	}

}
