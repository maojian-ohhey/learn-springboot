package com.github.maojian.getConfigurationParam;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GetConfigurationParamByEnvironment {

    @Resource
    private Environment environment;

    @Bean("printPort2")
    public void printPort(){
        String port = environment.getProperty("server.port");
        System.out.println(port);
    }
}
