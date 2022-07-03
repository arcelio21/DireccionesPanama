package com.project.model;


import javax.persistence.*;

@Entity
@Table(name = "TVILLAGES")
public class Tvillage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 35)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DISTRICTFK")
    private Tdistrict idDistrictfk;

    public Tvillage() {
    }

    public Tvillage(Integer id) {
        this.id = id;
    }

    public Tvillage(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tvillage(Integer id, String name, Tdistrict idDistrictfk) {
        this.id = id;
        this.name = name;
        this.idDistrictfk = idDistrictfk;
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

    public Tdistrict getIdDistrictfk() {
        return idDistrictfk;
    }

    public void setIdDistrictfk(Tdistrict idDistrictfk) {
        this.idDistrictfk = idDistrictfk;
    }

}