package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface FeederProblemJPA extends
        JpaRepository<FeederProblemEntity,Long>,
        CrudRepository<FeederProblemEntity,Long>,
        JpaSpecificationExecutor<FeederProblemEntity>,
        Serializable {

}
