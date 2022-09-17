package com.webapi.springbootrestfulapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootRestfulApiApplication {
    private final static Logger logger = LoggerFactory.getLogger(SpringBootRestfulApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestfulApiApplication.class, args);
    }

}
