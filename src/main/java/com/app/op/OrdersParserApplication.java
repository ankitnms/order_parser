package com.app.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.op.service.OrderParserService;

@SpringBootApplication
public class OrdersParserApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OrdersParserApplication.class, args);
		OrderParserService orderParserService = context.getBean(OrderParserService.class);
		orderParserService.processFiles(args);
	}

}
