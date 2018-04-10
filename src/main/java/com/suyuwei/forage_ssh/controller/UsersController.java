package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 仓库管理者的菜单重定向
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
     * 进行账户密码验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public int doLogin(HttpServletRequest request) {
        int loginStatus = usersService.loginJudgement(request);
        return loginStatus;
    }

}
