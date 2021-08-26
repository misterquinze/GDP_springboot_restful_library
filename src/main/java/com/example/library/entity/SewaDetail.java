package com.example.library.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SewaDetail {
    @Id
    @SequenceGenerator(name = "SEWA_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "SEWA_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name="ID")
    private Long ID;

    @Column(name = "ISBN", nullable = false)
    private String ISBN;

    @Column(name = "PELANGGANID", nullable = false)
    private Long PELANGGANID;

    @Column(name = "TGLSEWA", nullable = false)
    private Date TGLSEWA;

    @Column(name = "LAMASEWA", nullable = false)
    private Long LAMASEWA;

    @Column(name = "KETERANGAN", nullable = true)
    private String KETERANGAN;

    @Column(name = "JUDUL", nullable = false)
    private String JUDUL;

    @Column(name = "PENGARANG", nullable = false)
    private String PENGARANG;

    @Column(name = "NAMA", nullable = false)
    private String NAMA;

    @Column(name = "EMAIL", nullable = false)
    private String EMAIL;

    @Column(name = "KODEPEL", nullable = false)
    private String KODEPEL;

    @Column(name = "TELP", nullable = true)
    private String TELP;


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Long getPELANGGANID() {
        return this.PELANGGANID;
    }

    public void setPELANGGANID(Long PELANGGANID) {
        this.PELANGGANID = PELANGGANID;
    }

    public Date getTGLSEWA() {
        return this.TGLSEWA;
    }

    public void setTGLSEWA(Date TGLSEWA) {
        this.TGLSEWA = TGLSEWA;
    }

    public Long getLAMASEWA() {
        return this.LAMASEWA;
    }

    public void setLAMASEWA(Long LAMASEWA) {
        this.LAMASEWA = LAMASEWA;
    }

    public String getKETERANGAN() {
        return this.KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN) {
        this.KETERANGAN = KETERANGAN;
    }

    public String getJUDUL() {
        return this.JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getPENGARANG() {
        return this.PENGARANG;
    }

    public void setPENGARANG(String PENGARANG) {
        this.PENGARANG = PENGARANG;
    }

    public String getNAMA() {
        return this.NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getKODEPEL() {
        return this.KODEPEL;
    }

    public void setKODEPEL(String KODEPEL) {
        this.KODEPEL = KODEPEL;
    }

    public String getTELP() {
        return this.TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }


    
}