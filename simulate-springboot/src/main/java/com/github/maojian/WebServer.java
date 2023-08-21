package com.github.maojian;

import org.springframework.web.context.WebApplicationContext;

public interface WebServer {

    void start(WebApplicationContext applicationContext) throws Exception;
}
