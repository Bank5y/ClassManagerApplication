package com.swpu.lihongye.controller;


import com.swpu.lihongye.service.ClassService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@Configuration
public class SpringBootControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootControllerApplication.class, args);
    }
}
