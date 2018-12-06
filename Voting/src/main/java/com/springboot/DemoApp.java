package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.springboot.dao")
@SpringBootApplication
public class DemoApp extends SpringBootServletInitializer{

    public static void main(String[] args){
        SpringApplication.run(DemoApp.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(DemoApp.class);
    }
}
