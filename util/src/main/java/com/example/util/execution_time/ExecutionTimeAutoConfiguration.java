package com.example.util.execution_time;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutionTimeAutoConfiguration {

    @Bean
    ExecutionTimeAspect executionTimeAspect(){return new ExecutionTimeAspect();}
}
