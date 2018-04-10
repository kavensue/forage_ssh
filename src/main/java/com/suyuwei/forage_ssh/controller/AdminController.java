package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录重定向
     * @return
     */
    @RequestMapping(value = "/adminLogin",method = RequestMethod.GET)
    public String adminLogin(){
        return "adminLogin";
    }

    @RequestMapping(value = "/adminUserManagement",method = RequestMethod.GET)
    public String adminUserManagement(){return "adminUserManagement";}

    @RequestMapping(value = "/adminForageManagement",method = RequestMethod.GET)
    public String adminForageManagement(){return "adminForageManagement";}

    @RequestMapping(value = "/adminForageGainManagement",method = RequestMethod.GET)
    public String adminForageGainManagement(){return "adminForageGainManagement";}

    /**
     * 进行密码验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/doAdminLogin", method = RequestMethod.GET)
    public String doLogin(HttpServletRequest request) {
        int loginStatus = adminService.loginJudgement(request);
        if (loginStatus == 0)
            return "adminIndex";
        else
            return "adminLogin";
    }


}
