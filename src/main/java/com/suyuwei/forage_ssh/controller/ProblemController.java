package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    //重定向
    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    public String problem(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return "/problem";
    }

    @RequestMapping(value = "/problemSave",method = RequestMethod.POST)
    @ResponseBody
    public String problemSave(HttpServletRequest request){
        problemService.ProblemSave(request);
        return "success!";
    }
}

