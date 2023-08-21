package com.github.maojian;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

public class SimulateSpringApplication {
    public static void run(Class clazz) {
        // 1. 创建spring容器
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        WebServer webServer = getWebServer(applicationContext);
        try {
            webServer.start(applicationContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebServer getWebServer(AnnotationConfigWebApplicationContext applicationContext) {
        Map<String, WebServer> webServerMap = applicationContext.getBeansOfType(WebServer.class);
        if (webServerMap.isEmpty()) throw new NullPointerException();
        if (webServerMap.size() > 1) throw new IllegalStateException();
        return webServerMap.values().stream().findFirst().get();
    }
}
