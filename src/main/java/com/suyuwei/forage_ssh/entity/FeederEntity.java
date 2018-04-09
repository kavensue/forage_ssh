package com.suyuwei.forage_ssh.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "feeder")
public class FeederEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "feeder_id")
    private Long id;

    @Column(name = "feeder_name")
    private String name;

    @Column(name = "feeder_password")
    private  String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
