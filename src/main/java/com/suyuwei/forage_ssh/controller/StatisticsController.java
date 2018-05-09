package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    //统计最近五个月的饲料入库总量
    @RequestMapping(value = "/forageStatisticsIn",method = RequestMethod.POST)
    @ResponseBody
    public String forageStatisticsIn(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return statisticsService.forageStatisticsIn(request);
    }

    //统计最近五个月的问题反馈数量
    @RequestMapping(value = "/problemStatistics",method = RequestMethod.POST)
    @ResponseBody
    public String problemStatistics(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return statisticsService.problemStatistics(request);
    }
}
