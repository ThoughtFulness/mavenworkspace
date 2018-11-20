package com.my.sm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * className:SpringBootMainApp
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-09 14:50
 */
@EnableTransactionManagement//spring boot 开启注解式事务
@SpringBootApplication
@MapperScan("com.my.sm.dao")
public class SpringBootMainApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApp.class);
	}

}
