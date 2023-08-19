package com.github.maojian.getApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider3 {

    private ApplicationContext applicationContext;

    public ApplicationContextProvider3(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean("user03")
    public User user(){
        return new User("鷇音子",20);
    }

    @Bean("printApplicationContext03")
    public void printApplicationContext(){
        System.out.println(applicationContext.getBean("user03"));
    }
}
