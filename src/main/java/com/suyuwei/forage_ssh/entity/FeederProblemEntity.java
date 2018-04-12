package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "feeder_problem")
public class FeederProblemEntity {
    @Id
    @GeneratedValue
    @Column(name = "feeder_problem_id")
    private Long id;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "problem_place")
    private String place;

    @Column(name = "problem_type")
    private String type;

    @Column(name = "feeder_problem_remark")
    private String remark;

    @Column(name = "feeder_problem_time")
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeederName() {
        return feederName;
    }

    public void setFeederName(String feederName) {
        this.feederName = feederName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
