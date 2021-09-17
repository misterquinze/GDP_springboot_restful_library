package com.example.library.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserRoleView {
    @Id
    @SequenceGenerator(name = "USERROLEVIEW_SEQ", allocationSize=1)
    @GeneratedValue(generator = "USERROLEVIEW_SEQ", strategy=GenerationType.SEQUENCE)
    private Long ID;

    @Column(nullable = false)
    private Long USERID;

    @Column(nullable = false)
    private Long AKTIF;

    @Column(nullable = false)
    private String NAME;

    private String ZIPCODE;

    @Column(nullable = false)
    private String EMAIL;

    @Column(nullable = false)
    private String USERNAME;
    
    @Column(nullable = false)
    private String PASSWORD;

    @Column(nullable = false)
    private Date REGISTER_DATE;

    @Column(nullable = false)
    private Long ROLEID;

    @Column(nullable = false)
    private String ROLE;


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getUSERID() {
        return this.USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }

    public Long getAKTIF() {
        return this.AKTIF;
    }

    public void setAKTIF(Long AKTIF) {
        this.AKTIF = AKTIF;
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

    public Date getREGISTER_DATE() {
        return this.REGISTER_DATE;
    }

    public void setREGISTER_DATE(Date REGISTER_DATE) {
        this.REGISTER_DATE = REGISTER_DATE;
    }

    public Long getROLEID() {
        return this.ROLEID;
    }

    public void setROLEID(Long ROLEID) {
        this.ROLEID = ROLEID;
    }

    public String getROLE() {
        return this.ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

}
