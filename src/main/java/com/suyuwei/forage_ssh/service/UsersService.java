package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.UsersJPA;
import com.suyuwei.forage_ssh.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UsersService {
    @Autowired
    private UsersJPA usersJPA;

    public int loginJudgement(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsersEntity usersEntity;
        usersEntity=usersJPA.findByName(username);
        if(usersEntity.getName()==null)
            return 0;//没有此用户
        else if(usersEntity.getPassword().equals(password)&&usersEntity.getType().equals("喂饲人员")){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("userid",usersEntity.getId());
            session.setAttribute("username",username);
            return 1;//用户密码正确，身份为喂饲人员
        }
        else if(usersEntity.getPassword().equals(password)&&usersEntity.getType().equals("仓库管理员")){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("userid",usersEntity.getId());
            session.setAttribute("username",username);
            return 2;//用户密码正确，身份为仓库管理员
        }
            return 3;//密码错误
    }


}
