package com.suyuwei.forage_ssh.controller;

import com.suyuwei.forage_ssh.entity.UsersEntity;
import com.suyuwei.forage_ssh.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    /**
     * 进行账户密码验证
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public int doLogin(HttpServletRequest request,HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        int loginStatus = usersService.loginJudgement(request);
        return loginStatus;
    }

    //用户添加
    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    @ResponseBody
    public int userAdd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        int addStatus=usersService.userAdd(request);
        return addStatus;
    }

    //用户删除
    @RequestMapping(value = "/userDelete",method = RequestMethod.GET)
    @ResponseBody
    public int userDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        int deleteStatus=usersService.userDelete(request);
        return deleteStatus;
    }

    //用户查询
    @RequestMapping(value = "/userGet",method = RequestMethod.GET)
    @ResponseBody
    public List<UsersEntity> userGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Access-Control-Allow-Origin","*");
        return usersService.userGet(request);
    }

    //用户更新
    @RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
    @ResponseBody
    public int userUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        int updateStatus=usersService.userUpdate(request);
        return updateStatus;
    }
}
