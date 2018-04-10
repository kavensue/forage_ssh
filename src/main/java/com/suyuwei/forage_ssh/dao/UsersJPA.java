package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UsersJPA extends
        JpaRepository<UsersEntity,Long>,
        CrudRepository<UsersEntity,Long>,
        JpaSpecificationExecutor<UsersEntity>,
        Serializable {
    //由用户名查找用户信息
    @Query(value = "select * from admin where admin_name=?1",nativeQuery = true)
    public UsersEntity findByName(String username);
}
