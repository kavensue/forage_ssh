package com.suyuwei.forage_ssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    /**
     * 直接访问主页，做测试用
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
