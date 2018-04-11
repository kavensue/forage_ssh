package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ForageStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ForageStoreJPA extends
        JpaRepository<ForageStoreEntity,Long>,
        CrudRepository<ForageStoreEntity,Long>,
        JpaSpecificationExecutor<ForageStoreEntity>,
        Serializable {
    //由饲料种类查找饲料储量信息
    @Query(value = "select *from forage_store where forage_store_type=?1",nativeQuery = true)
    public ForageStoreEntity findbytype(String type);
}
