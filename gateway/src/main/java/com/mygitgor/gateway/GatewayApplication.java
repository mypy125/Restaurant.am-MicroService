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
				.route("restaurant", r -> r.path("/api/restaurants/**").uri("http://localhost:8081/"))
				.route("cart", r -> r.path("/api/carts/**").uri("http://localhost:8082/"))
				.route("user", r -> r.path("/api/users/**").uri("http://localhost:8083/"))
				.route("address", r -> r.path("/api/address/**").uri("http://localhost:8084/"))
				.route("address", r -> r.path("/api/foods/**").uri("http://localhost:8085/"))
				.build();
	}
}
