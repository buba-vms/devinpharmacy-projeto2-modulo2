package com.pharmacy.devin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevinApplication.class, args);
	}

}
