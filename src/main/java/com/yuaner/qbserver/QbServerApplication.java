
package com.yuaner.qbserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.yuaner.qbserver.mapper")
public class QbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QbServerApplication.class, args);
    }



}
