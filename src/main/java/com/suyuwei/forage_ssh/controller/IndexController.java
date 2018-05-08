package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    private StatisticsService statisticsService;
    /**
     * 直接访问主页，做测试用
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "forageStatistics",method = RequestMethod.GET)
    public String forageStatistics(){
        return "forageStatistics";
    }

    @RequestMapping(value = "adminIndex",method = RequestMethod.GET)
    public String adminIndex(){
        return "adminIndex";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "problemStatistics",method = RequestMethod.GET)
    public String problemStatistics(){
        return "problemStatistics";
    }
}
