package com.myprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.myprj.controller,com.myprj.model")

public class SpringAngularPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularPrjApplication.class, args);
	}

}
