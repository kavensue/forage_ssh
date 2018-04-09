package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface AdminJPA extends
        JpaRepository<AdminEntity,Long>,
        CrudRepository<AdminEntity,Long>,
        JpaSpecificationExecutor<AdminEntity>,
        Serializable {
    //由用户名查找饲养员信息
    @Query(value = "select * from admin where admin_name=?1",nativeQuery = true)
    public AdminEntity findByName(String username);
}
