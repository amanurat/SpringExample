package com.training.spring.config;

import com.training.spring.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: assanai.manurat
 * Date: 4/24/2014
 * Time: 10:44 PM
 */
@Configuration
@ComponentScan(value="com.training.spring")
public class MyConfiguration {

    @Bean
    public MyService getMyService() {
        return new MyService();
    }
}
