package com.example.demo;

import com.example.demo.fruits.*;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Apple apple = context.getBean(Apple.class);
		apple.print();
		apple.setName("APPLE");
	}

	@Configuration
	private static class Config {

		public Config(){
			
		}

		@Bean (name = "b")
		Banana banana() {
			return new Banana();
		}

		@Bean(name = "1")
		Banana b1() {
			return new Banana();
		}

		@Bean (name = "s")
		String string(){
			return "123";
		}

		@Bean
		Apple apple() {
			Apple apple = new Apple();
			apple.setBanana(banana());
			return apple;
		}

		@Bean
		Audit audit(){
			return new Audit();
		}

	}
}
