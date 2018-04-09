package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ForageGainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ForageGainJPA extends
        JpaRepository<ForageGainEntity,Long>,
        CrudRepository<ForageGainEntity,Long>,
        JpaSpecificationExecutor<ForageGainEntity>,
        Serializable {
}
