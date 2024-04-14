package com.mygitgor.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRoutLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("cart", r -> r.path("/carts/**").uri("http://localhost:8082/"))
				.route("order", r -> r.path("/orders/**").uri("http://localhost:8081/"))
				.build();
	}
}
