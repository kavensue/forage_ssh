package com.suyuwei.forage_ssh.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleHelloWorld_2 {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
