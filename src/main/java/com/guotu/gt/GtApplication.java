package com.guotu.gt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.guotu.gt.mapper")
public class GtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtApplication.class, args);
    }

}
