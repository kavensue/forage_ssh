package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.FeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeederController {
    @Autowired
    private FeederService feederService;

    /**
     * 登录重定向
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 进行密码验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public String doLogin(HttpServletRequest request) {
        int loginStatu = feederService.loginJudgment(request);
        if (loginStatu == 0)
            return "index";
        else
            return "login";
    }
}
