package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ProblemJPA extends
        JpaRepository<ProblemEntity,Long>,
        CrudRepository<ProblemEntity,Long>,
        JpaSpecificationExecutor<ProblemEntity>,
        Serializable {
}
