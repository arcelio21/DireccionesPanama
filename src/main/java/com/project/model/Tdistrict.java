package com.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TDISTRICT")
public class Tdistrict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 35)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PROVINCEFK")
    private Tprovince idProvincefk;

    @OneToMany(mappedBy = "idDistrictfk",fetch = FetchType.LAZY)
    private List<Tvillage> tvillages = new ArrayList<>();


    public Tdistrict() {
    }

    public Tdistrict(Integer id) {
        this.id = id;
    }

    public Tdistrict(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tdistrict(Integer id, String name, Tprovince idProvincefk) {
        this.id = id;
        this.name = name;
        this.idProvincefk = idProvincefk;
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

    public Tprovince getIdProvincefk() {
        return idProvincefk;
    }

    public void setIdProvincefk(Tprovince idProvincefk) {
        this.idProvincefk = idProvincefk;
    }

    public List<Tvillage> getTvillages() {
        return tvillages;
    }

    public void setTvillages(List<Tvillage> tvillages) {
        this.tvillages = tvillages;
    }

}