package com.example.springbootproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootproducerApplication.class, args);
	}

}
