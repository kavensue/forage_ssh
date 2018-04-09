package com.suyuwei.forage_ssh.service;

import com.suyuwei.forage_ssh.dao.FeederJPA;
import com.suyuwei.forage_ssh.entity.FeederEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class FeederService {
    @Autowired
    private FeederJPA feederJPA;

    /**
     * 用户名密码正误判断的业务逻辑
     * @return
     */
    public int loginJudgment(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        FeederEntity feederEntity;
        feederEntity = feederJPA.findByName(username);
        if (feederEntity.getName() == null)
            return 1;//没有此用户
        else if (feederEntity.getPassword().equals(password)){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("userid",feederEntity.getId());
            session.setAttribute("username",username);
            return 0;//用户密码正确
        }
        else
            return 2;//密码错误
    }
}
