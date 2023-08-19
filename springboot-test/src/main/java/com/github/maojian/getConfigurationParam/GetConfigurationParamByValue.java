package com.github.maojian.getConfigurationParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GetConfigurationParamByValue {

    @Value("${server.port}")
    private String port;

    @Bean("printPort1")
    public void printPort(){
        System.out.println(port);
    }
}
