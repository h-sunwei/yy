package com.yy.sola;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启缓存
@MapperScan("com.yy.sola.mapper")
public class SolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolaApplication.class, args);
    }

}
