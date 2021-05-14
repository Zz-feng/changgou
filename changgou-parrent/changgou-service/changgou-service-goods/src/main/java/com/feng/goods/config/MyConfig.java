package com.feng.goods.config;

import entity.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    //id生成器
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0);
    }
}
