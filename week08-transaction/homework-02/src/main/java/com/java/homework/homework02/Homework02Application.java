package com.java.homework.homework02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java.homework.homework02.mapper")
public class Homework02Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework02Application.class, args);
	}

}
