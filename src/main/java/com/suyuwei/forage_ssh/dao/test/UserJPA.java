package com.suyuwei.forage_ssh.dao.test;

import com.suyuwei.forage_ssh.entity.test.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity, Long>,
        CrudRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {

}
