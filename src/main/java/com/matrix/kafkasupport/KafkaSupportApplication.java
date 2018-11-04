package com.matrix.kafkasupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.matrix.kafkasupport.*")
@SpringBootApplication
public class KafkaSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSupportApplication.class, args);
	}
}
