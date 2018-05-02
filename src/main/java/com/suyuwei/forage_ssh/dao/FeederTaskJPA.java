package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.FeederTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface FeederTaskJPA extends
        JpaRepository<FeederTaskEntity,Long>,
        CrudRepository<FeederTaskEntity,Long>,
        JpaSpecificationExecutor<FeederTaskEntity>,
        Serializable {
}
