package com.example.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {
    @Id
    @SequenceGenerator(name = "ROLE_SEQ", allocationSize=1)
    @GeneratedValue(generator = "ROLE_SEQ", strategy=GenerationType.SEQUENCE)
    private Long ID;

    @Column(nullable = false)
    private String ROLE;

    private String KETERANGAN;


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getROLE() {
        return this.ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public String getKETERANGAN() {
        return this.KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }

}
