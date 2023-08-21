package com.github.maojian;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyWebServer implements WebServer{

    private static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String MAPPING_URL = "/*";

    @Override
    public void start(WebApplicationContext applicationContext) throws Exception {
        Server server = new Server(DEFAULT_PORT);
        server.setHandler(servletContextHandler(applicationContext));
        server.start();
        server.join();
    }

    private ServletContextHandler servletContextHandler(WebApplicationContext context) {
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath(CONTEXT_PATH);
        handler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        handler.addEventListener(new ContextLoaderListener(context));
        return handler;
    }
}

