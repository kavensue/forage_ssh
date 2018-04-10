package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.AdminJPA;
import com.suyuwei.forage_ssh.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AdminService {
    @Autowired
    private AdminJPA adminJPA;

    public int loginJudgement(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminEntity adminEntity;
        adminEntity=adminJPA.findByName(username);
        if(adminEntity.getName()==null)
            return 1;//没有此用户
        else if(adminEntity.getPassword().equals(password)){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("userid",adminEntity.getId());
            session.setAttribute("username",username);
            return 0;//用户密码正确
        }
        else
            return 2;//密码错误
    }


}
