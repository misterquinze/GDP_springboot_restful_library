package com.example.library.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Users {
    @Id
    @SequenceGenerator(name = "USERS_SEQ", allocationSize=1)
    @GeneratedValue(generator = "USERS_SEQ", strategy=GenerationType.SEQUENCE)
    private Long ID;

    @Column(nullable = false)
    private String NAME;

    private String ZIPCODE;

    @Column(nullable = false)
    private String EMAIL;

    @Column(nullable = false)
    private String USERNAME;
    
    @Column(nullable = false)
    private String PASSWORD;

    @CreationTimestamp
    @Column(name="REGISTER_DATE")
    private Timestamp REGDATE;
  


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getZIPCODE() {
        return this.ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSERNAME() {
        return this.USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Timestamp getREGDATE() {
        return this.REGDATE;
    }

    public void setREGDATE(Timestamp REGDATE) {
        this.REGDATE = REGDATE;
    }
   

}
