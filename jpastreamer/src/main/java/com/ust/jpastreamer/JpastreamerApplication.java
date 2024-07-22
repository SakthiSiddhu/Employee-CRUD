package com.ust.jpastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ust.jpastreamer","com.speedment.jpastreamer"})
public class JpastreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpastreamerApplication.class, args);
	}

}
