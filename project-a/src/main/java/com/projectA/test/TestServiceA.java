package com.projectA.test;

import org.springframework.stereotype.Component;

@Component
public class TestServiceA {

    public String getMessageFromServiceA() {
        return "Message from Service A";
    }

}
