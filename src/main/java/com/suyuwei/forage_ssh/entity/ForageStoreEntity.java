package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "forage_store")
public class ForageStoreEntity {
    @Id
    @GeneratedValue
    @Column(name = "forage_store_id")
    private Long id;

    @Column(name = "forage_store_type")
    private String type;

    @Column(name = "forage_store_number")
    private Long number;

    @Column(name = "forage_store_unit")
    private String unit;

    @Column(name = "forage_store_time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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
}
