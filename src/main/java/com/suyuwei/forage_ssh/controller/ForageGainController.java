package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.ForageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ForageGainController {
    @Autowired
    private ForageService forageService;

    //重定向
    @RequestMapping(value = "/foragegain",method = RequestMethod.GET)
    public String problem(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        return "/foragegain";
    }

    @RequestMapping(value = "/forageGainSave",method = RequestMethod.POST)
    @ResponseBody
    public String ForageGainSave(HttpServletRequest request){
        forageService.ForageGainSave(request);
        return "success!";
    }
}
