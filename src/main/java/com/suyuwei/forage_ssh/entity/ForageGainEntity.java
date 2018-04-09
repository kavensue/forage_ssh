package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "forage_gain")
public class ForageGainEntity {
    @Id
    @GeneratedValue
    @Column(name = "forage_gain_id")
    private Long id;

    @Column(name = "feeder_id")
    private Long feederId;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "forage_gain_place")
    private String forageGainPlace;

    @Column(name = "forage_gain_time")
    private String forageGainTime;

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

    public String getForageGainPlace() {
        return forageGainPlace;
    }

    public void setForageGainPlace(String forageGainPlace) {
        this.forageGainPlace = forageGainPlace;
    }

    public String getForageGainTime() {
        return forageGainTime;
    }

    public void setForageGainTime(String forageGainTime) {
        this.forageGainTime = forageGainTime;
    }
}
