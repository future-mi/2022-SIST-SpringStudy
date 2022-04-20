package com.sist.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.music.dao", "com.sist.music.controller", "com.sist.music.service"})
public class SpingBootMyBatisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootMyBatisProjectApplication.class, args);
	}

}
