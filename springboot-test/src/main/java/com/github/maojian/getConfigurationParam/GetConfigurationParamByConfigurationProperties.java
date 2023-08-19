package com.github.maojian.getConfigurationParam;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "server")
public class GetConfigurationParamByConfigurationProperties {
    private String port;

    public void setPort(String port) {
        this.port = port;
    }

    @Bean("printPort3")
    public void printPort(){
        System.out.println(port);
    }
}
