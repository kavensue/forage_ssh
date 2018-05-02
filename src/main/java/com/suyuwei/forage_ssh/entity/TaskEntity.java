package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue
    @Column(name = "feeder_task_id")
    private Long id;

    @Column(name = "feeder_task_place")
    private String place;

    @Column(name = "feeder_task_target")
    private String target;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
