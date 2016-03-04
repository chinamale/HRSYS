/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Clifton T. Mtengezo
 */
@MappedSuperclass
public class AddressFields extends AuditFields {
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "LOCATION", nullable = true,length = 30)
    private String location;

    @Column(name = "ADDRESS1", nullable = true,length = 30)
    private String address1;
    
    @Column(name = "ADDRESS2", nullable = true,length = 30)
    private String address2;
    
    @Column(name = "ADDRESS3", nullable = true,length = 30)
    private String address3;
    
    @Column(name = "ADDRESS4", nullable = true,length = 30)
    private String address4;
    
    @Column(name = "TELEPHONE", nullable = true,length = 30)
    private String telephone;
    
    @Column(name = "EMAILADDRESS", nullable = true,length = 30)
    private String emailaddress;
    
//    @Override
//    public Integer getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Integer id) {
//        this.id = id;
//    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }
    
}
