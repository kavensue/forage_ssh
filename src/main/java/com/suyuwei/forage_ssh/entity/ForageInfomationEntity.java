package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "forage_info")
public class ForageInfomationEntity {
    @Id
    @GeneratedValue
    @Column(name = "forage_info_id")
    private Long id;

    @Column(name = "forage_info_type")
    private String type;

    @Column(name = "forage_info_number")
    private Long number;

    @Column(name = "forage_info_unit")
    private String unit;

    @Column(name = "forage_info_time")
    private String time;

    @Column(name="forage_info_handler")
    private String adminName;

    @Column(name = "forage_gain_feeder")
    private String feederName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getFeederName() {
        return feederName;
    }

    public void setFeederName(String feederName) {
        this.feederName = feederName;
    }
}
