package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		// PaymentService p = new PaymentService();
		// OrderService order = new OrderService(p);
		// order.placeOrder();

		ApplicationContext context = new ApplicationContext(AppConfig.class);
		

	}

}
