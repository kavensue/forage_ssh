package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface TaskJPA extends
        JpaRepository<TaskEntity,Long>,
        CrudRepository<TaskEntity,Long>,
        JpaSpecificationExecutor<TaskEntity>,
        Serializable {
}
