package com.test.test.controller;

import com.projectA.test.TestServiceA;
import com.projectB.test.TestServiceB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApp {

    private TestServiceA testServiceA;
    private TestServiceB testServiceB;

    public TestRestApp(TestServiceA testServiceA, TestServiceB testServiceB) {
        this.testServiceA = testServiceA;
        this.testServiceB = testServiceB;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping("/get-message-a")
    public String getClassA() {
        return testServiceA.getMessageFromServiceA();
    }

    @GetMapping("/get-message-b")
    public String getClassB() {
        return testServiceB.getMessageFromServiceB();
    }
}
