package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.FeederForageGainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface FeederForageGainJPA extends
        JpaRepository<FeederForageGainEntity,Long>,
        CrudRepository<FeederForageGainEntity,Long>,
        JpaSpecificationExecutor<FeederForageGainEntity>,
        Serializable {
}
