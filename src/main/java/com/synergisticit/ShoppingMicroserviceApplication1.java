package com.synergisticit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingMicroserviceApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMicroserviceApplication1.class, args);
	}

}
