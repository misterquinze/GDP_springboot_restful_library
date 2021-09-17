package com.example.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserRole {
    @Id
    @SequenceGenerator(name = "USERROLE_SEQ", allocationSize=1)
    @GeneratedValue(generator = "USERROLE_SEQ", strategy=GenerationType.SEQUENCE)
    private Long ID;

    @Column(nullable = false)
    private Long USERID;

    @Column(nullable = false)
    private Long ROLEID;

    @Column(nullable = false)
    private Long AKTIF;


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

    public Long getROLEID() {
        return this.ROLEID;
    }

    public void setROLEID(Long ROLEID) {
        this.ROLEID = ROLEID;
    }

    public Long getAKTIF() {
        return this.AKTIF;
    }

    public void setAKTIF(Long AKTIF) {
        this.AKTIF = AKTIF;
    }

}
