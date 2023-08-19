package com.github.maojian.getApplicationContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextProvider2 implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean("user02")
    public User user(){
        return new User("天踦爵",19);
    }

    @Bean("printApplicationContext02")
    public void printApplicationContext(){
        System.out.println(applicationContext.getBean("user02"));
    }
}
