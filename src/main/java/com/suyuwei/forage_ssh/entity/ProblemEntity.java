package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "problem")
public class ProblemEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "problem_id")
    private Long id;

    @Column(name = "problem_place")
    private String place;

    @Column(name = "problem_type")
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
