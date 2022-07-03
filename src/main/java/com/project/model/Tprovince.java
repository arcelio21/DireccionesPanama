package com.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TPROVINCE")
public class Tprovince {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 35)
    private String name;

    @OneToMany(mappedBy = "idProvincefk",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Tdistrict> tdistricts = new ArrayList<>();

    public Tprovince() {
    }

    public Tprovince(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tdistrict>getTdistricts() {
        return tdistricts;
    }

    public void setTdistricts(List<Tdistrict> tdistricts) {
        this.tdistricts = tdistricts;
    }

}