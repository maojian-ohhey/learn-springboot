package com.github.maojian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceAutoConfiguration {

    @Bean
    @SimulateConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer(){
        return new TomcatWebServer();
    }

    @Bean
    @SimulateConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer(){
        return new JettyWebServer();
    }
}
