package com.suyuwei.forage_ssh.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleHelloWorld {
    @RequestMapping("/home")
    public String home() {
        return "hello world!!!";
    }
}
