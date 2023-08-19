package com.github.maojian.getApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ApplicationContextProvider1 {

//    @Autowired
    @Resource
    private ApplicationContext applicationContext;

    @Bean("user01")
    public User user(){
        return new User("素还真",18);
    }

    @Bean("printApplicationContext01")
    public void printApplicationContext(){
        System.out.println(applicationContext.getBean("user01"));
    }
}
