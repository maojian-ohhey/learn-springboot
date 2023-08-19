package com.github.maojian.service.impl;

import com.github.maojian.service.AsyncTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTestServiceImpl implements AsyncTestService {

    @Async
    @Override
    public void doAsync() {
        System.out.println("------------doAsync---------------");
        throw new IllegalArgumentException("");
    }
}
