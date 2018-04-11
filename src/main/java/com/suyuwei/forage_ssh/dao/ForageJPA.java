package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ForageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ForageJPA extends
        JpaRepository<ForageEntity,Long>,
        CrudRepository<ForageEntity,Long>,
        JpaSpecificationExecutor<ForageEntity>,
        Serializable {
}
