package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
//@EnableConfigurationProperties(ReadProperties.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		

	}

}
