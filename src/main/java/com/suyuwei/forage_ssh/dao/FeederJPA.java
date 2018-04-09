package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.FeederEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface FeederJPA extends
        JpaRepository<FeederEntity,Long>,
        CrudRepository<FeederEntity,Long>,
        JpaSpecificationExecutor<FeederEntity>,
        Serializable{
    //由用户名查找饲养员信息
    @Query(value = "select * from feeder where feeder_name=?1",nativeQuery = true)
    public FeederEntity findByName(String username);
}
