package com.example.quartzhello.service.impl;

import com.example.quartzhello.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
