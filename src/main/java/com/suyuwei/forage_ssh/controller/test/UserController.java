package com.suyuwei.forage_ssh.controller.test;

import com.suyuwei.forage_ssh.dao.test.UserJPA;
import com.suyuwei.forage_ssh.entity.test.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     *
     * @return
     * @Param entity
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity entity) {
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(Long id) {
        userJPA.delete(id);
        return userJPA.findAll();
    }

    /**
     * 添加用户方法
     * @param name
     * @param age
     * @param address
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("address") String address){
        UserEntity userEntity=new UserEntity();
        userEntity.setId((long) 33);
        userEntity.setName(name);
        userEntity.setAddress(address);
        userEntity.setAge(age);
        userJPA.save(userEntity);
        return "add success";
    }
}
