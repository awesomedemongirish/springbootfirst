package com.girish.springboot.my_first_project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext cta = SpringApplication.run(App.class, args);

	}

}
