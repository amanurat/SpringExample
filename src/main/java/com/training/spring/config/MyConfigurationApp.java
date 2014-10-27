package com.training.spring.config;

import com.training.spring.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 9:07 AM
 */
public class MyConfigurationApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyService myService = context.getBean(MyService.class);
        myService.message("Hello world!");

        System.out.println("My message is : " + myService.getMessage());
    }
}
