package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.FeederProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface FeederProblemJPA extends
        JpaRepository<FeederProblemEntity,Long>,
        CrudRepository<FeederProblemEntity,Long>,
        JpaSpecificationExecutor<FeederProblemEntity>,
        Serializable {
    //统计最近五个月的全部问题数量
    @Query(value = "select count(feeder_problem_id) from feeder_problem where feeder_problem_time BETWEEN date_SUB(NOW(), INTERVAL ?1 MONTH) AND NOW() GROUP BY DATE_FORMAT(feeder_problem_time,'%Y-%m')",nativeQuery = true)
    public List<Long> findCountProblem(Long months);
}
