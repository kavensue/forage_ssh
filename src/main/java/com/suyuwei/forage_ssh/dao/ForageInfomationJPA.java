package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ForageInfomationJPA extends
        JpaRepository<ForageInfomationEntity,Long>,
        CrudRepository<ForageInfomationEntity,Long>,
        JpaSpecificationExecutor<ForageInfomationEntity>,
        Serializable {
}
