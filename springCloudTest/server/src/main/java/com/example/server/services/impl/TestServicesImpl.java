package com.example.server.services.impl;

import com.example.server.services.TestServices;
import org.springframework.stereotype.Service;

@Service
public class TestServicesImpl implements TestServices {

    @Override
    public String get(String name) {
        return "参数name：" + name;
    }
}