package com.lyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLydApplication {
	/**
	 * SpringbootLydApplication类要与controller在同一级下面这样才能扫描到@controller注解
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLydApplication.class, args);
	}

}
