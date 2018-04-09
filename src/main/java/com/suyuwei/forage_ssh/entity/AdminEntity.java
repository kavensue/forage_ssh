package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_password")
    private String password;

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
