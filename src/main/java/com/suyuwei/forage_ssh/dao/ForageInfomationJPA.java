package com.suyuwei.forage_ssh.dao;

import com.suyuwei.forage_ssh.entity.ForageInfomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface ForageInfomationJPA extends
        JpaRepository<ForageInfomationEntity,Long>,
        CrudRepository<ForageInfomationEntity,Long>,
        JpaSpecificationExecutor<ForageInfomationEntity>,
        Serializable {
    //由饲料种类和仓库管理员姓名来统计饲料入库
    @Query(value = "select sum(forage_info_number) from forage_info where forage_info_type=?1 and forage_info_handler=?2 AND forage_gain_feeder IS NULL and forage_info_time BETWEEN date_SUB(NOW() ,INTERVAL 5 MONTH) and NOW() GROUP BY DATE_FORMAT(forage_info_time,'%Y-%m')",nativeQuery = true)
    public List<Long> findByTypeAndNameIn(String forageType,String adminName);

    //由饲料种类和仓库管理员姓名来统计饲料出库
    @Query(value = "select sum(forage_info_number) from forage_info where forage_info_type=?1 and forage_info_handler=?2 AND forage_gain_feeder IS NOT NULL and forage_info_time BETWEEN date_SUB(NOW() ,INTERVAL 5 MONTH) and NOW() GROUP BY DATE_FORMAT(forage_info_time,'%Y-%m')",nativeQuery = true)
    public List<Long> findByTypeAndNameOut(String forageType,String adminName);
}
