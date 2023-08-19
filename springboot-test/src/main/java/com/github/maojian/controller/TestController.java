package com.github.maojian.controller;

import com.github.maojian.service.AsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @Autowired
    private AsyncTestService asyncTestService;

    @RequestMapping("/test")
    public String test() {
        return port;
    }

    @RequestMapping("/async")
    public String async() {
        asyncTestService.doAsync();
        return "success";
    }


}
