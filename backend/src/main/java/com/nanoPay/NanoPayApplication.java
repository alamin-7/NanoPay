package com.nanoPay;

import com.nanoPay.config.DotenvInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NanoPayApplication {
	public static void main(String[] args) {
		SpringApplication.run(NanoPayApplication.class, args);

/*		SpringApplication app = new SpringApplication(NanoPayApplication.class);
		app.addInitializers(new DotenvInitializer());
		app.run(args);*/

	}
}
