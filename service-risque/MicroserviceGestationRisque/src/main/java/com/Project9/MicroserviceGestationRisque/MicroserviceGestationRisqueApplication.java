package com.Project9.MicroserviceGestationRisque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class MicroserviceGestationRisqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGestationRisqueApplication.class, args);
	}

}
