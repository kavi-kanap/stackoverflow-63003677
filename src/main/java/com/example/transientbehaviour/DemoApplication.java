package com.example.transientbehaviour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		EntityService entityService = context.getBean(EntityService.class);
		System.out.println("---------------");
		entityService.mergeBehaviourUnManagedEntity();
		System.out.println("---------------");
		entityService.mergeBehaviourManagedEntity();
		System.out.println("---------------");
		entityService.refreshBehaviour();
		System.out.println("---------------");

	}
}
