package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "feeder_task")
public class FeederTaskEntity {
    @Id
    @GeneratedValue
    @Column(name = "feeder_task_id")
    private Long id;

    @Column(name = "feeder_id")
    private Long feederId;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "task_place")
    private String place;

    @Column(name = "feed_task_time")
    private String time;

    @Column(name = "feed_task_note")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
