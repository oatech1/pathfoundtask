package com.oatech.PathFoundTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PathFoundTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathFoundTaskApplication.class, args);
	}

}
