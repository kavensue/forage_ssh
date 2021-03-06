package com.suyuwei.forage_ssh.entity;

import javax.persistence.*;

@Entity
@Table(name = "forage")
public class ForageEntity {
    @Id
    @GeneratedValue
    @Column(name = "forage_id")
    private Long id;

    @Column(name = "forage_type")
    private String type;

    @Column(name = "forage_unit")
    private String unit;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
