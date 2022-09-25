package com.order.springboottesttransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.order.springboottesttransaction.mapper")
@SpringBootApplication
public class SpringbootTestTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestTransactionApplication.class, args);
    }

}
