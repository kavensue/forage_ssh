package com.suyuwei.forage_ssh.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyuwei.forage_ssh.dao.UsersJPA;
import com.suyuwei.forage_ssh.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersJPA usersJPA;
    /**
     * 用户登录验证
     * @param request
     * @return
     */
    public int loginJudgement(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsersEntity usersEntity;
        usersEntity=usersJPA.findByName(username);
        if(usersEntity==null)
            return 0;//没有此用户
        else if(usersEntity.getPassword().equals(password)&&usersEntity.getType().equals("喂饲人员")){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("feederId",usersEntity.getId());
            session.setAttribute("feederName",username);
            return 1;//用户密码正确，身份为喂饲人员
        }
        else if(usersEntity.getPassword().equals(password)&&usersEntity.getType().equals("仓库管理员")){
            //创建session对象存储用户信息
            HttpSession session=request.getSession();
            session.setAttribute("adminId",usersEntity.getId());
            session.setAttribute("adminName",username);
            return 2;//用户密码正确，身份为仓库管理员
        }
            return 3;//密码错误
    }

    //用户添加
    public int userAdd(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        String name=jsonObject.getString("name");
        String password=jsonObject.getString("password");
        String type=jsonObject.getString("type");
        String sex=jsonObject.getString("sex");

        UsersEntity usersEntity=new UsersEntity();
        usersEntity.setName(name);
        usersEntity.setPassword(password);
        usersEntity.setType(type);
        usersEntity.setSex(sex);
        usersJPA.save(usersEntity);
        return 0;
    }

    //用户删除
    public int userDelete(HttpServletRequest request) throws IOException {
        String userId=request.getParameter("id");
        Long id=Long.valueOf(userId);

        usersJPA.delete(id);
        return 0;
    }

    //用户查询
    public List<UsersEntity> userGet(HttpServletRequest request){
        List<UsersEntity> usersEntityList;
        usersEntityList=usersJPA.findAll();
        return  usersEntityList;
    }

    //用户修改
    public int userUpdate(HttpServletRequest request) throws IOException {
        BufferedReader reader=request.getReader();
        String input;
        StringBuffer requestBody=new StringBuffer();
        while((input = reader.readLine()) != null) {
            requestBody.append(input);
        }
        JSONArray jsonArray=JSONArray.parseArray(requestBody.toString());
        JSONObject jsonObject=jsonArray.getJSONObject(0);

        Long id=jsonObject.getLong("id");
        String name=jsonObject.getString("name");
        String password=jsonObject.getString("password");
        String type=jsonObject.getString("type");
        String sex=jsonObject.getString("sex");

        UsersEntity usersEntity=new UsersEntity();
        usersEntity.setId(id);
        usersEntity.setName(name);
        usersEntity.setPassword(password);
        usersEntity.setType(type);
        usersEntity.setSex(sex);
        usersJPA.save(usersEntity);
        return 0;
    }
}
