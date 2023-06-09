package com.api.babercontrol.BarberControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BarberControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberControlApplication.class, args);
	}

}
