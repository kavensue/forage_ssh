package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "feeder_forage_gain")
public class FeederForageGainEntity {
    @Id
    @GeneratedValue
    @Column(name = "feeder_forage_gain_id")
    private Long id;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "feeder_forage_gain_type")
    private String type;

    @Column(name = "feeder_forage_gain_number")
    private Long number;

    @Column(name = "feeder_forage_gain_unit")
    private String unit;

    @Column(name = "feeder_forage_gain_time")
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
}
