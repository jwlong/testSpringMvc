package com.dxfjyygy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dxfjyygy")
public class TestSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringMvcApplication.class, args);
    }

}
