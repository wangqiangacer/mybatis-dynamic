package com.jacken.mybatisdynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.jacken.mybatisdynamic.dao")
public class MybatisDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDynamicApplication.class, args);
    }

}
