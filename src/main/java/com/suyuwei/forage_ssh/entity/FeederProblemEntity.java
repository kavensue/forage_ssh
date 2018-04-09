package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "feeder_problem")
public class FeederProblemEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "feeder_problem_id")
    private Long id;

    @Column(name = "feeder_id")
    private Long feederId;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "problem_place")
    private String problemPlace;

    @Column(name = "problem_type")
    private String problemType;

    @Column(name = "feeder_problem_remark")
    private String feederProblemRemark;

    @Column(name = "feeder_problem_time")
    private String feederProblemTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFeederId() {
        return feederId;
    }

    public void setFeederId(Long feederId) {
        this.feederId = feederId;
    }

    public String getFeederName() {
        return feederName;
    }

    public void setFeederName(String feederName) {
        this.feederName = feederName;
    }

    public String getProblemPlace() {
        return problemPlace;
    }

    public void setProblemPlace(String problemPlace) {
        this.problemPlace = problemPlace;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getFeederProblemRemark() {
        return feederProblemRemark;
    }

    public void setFeederProblemRemark(String feederProblemRemark) {
        this.feederProblemRemark = feederProblemRemark;
    }

    public String getFeederProblemTime() {
        return feederProblemTime;
    }

    public void setFeederProblemTime(String feederProblemTime) {
        this.feederProblemTime = feederProblemTime;
    }
}
