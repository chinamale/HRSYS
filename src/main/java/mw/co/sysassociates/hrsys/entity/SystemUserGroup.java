/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Madalitso Chinamale
 */
@Entity
public class SystemUserGroup implements Serializable{
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Integer id;
    @Column (name = "USERNAME")
    private String username;
    @Column (name = "GROUPNAME")
    private String groupname;
    @Column (name = "ALLOWEDCOMPANY")
    private String allowedcompany;
    @Column (name = "ROLE")
    private String role;

    public SystemUserGroup() {
    }

    public SystemUserGroup( String username,  String role) {
        
        this.username = username;
       
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getAllowedcompany() {
        return allowedcompany;
    }

    public void setAllowedcompany(String allowedcompany) {
        this.allowedcompany = allowedcompany;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.groupname);
        hash = 29 * hash + Objects.hashCode(this.allowedcompany);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemUserGroup other = (SystemUserGroup) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.groupname, other.groupname)) {
            return false;
        }
        if (!Objects.equals(this.allowedcompany, other.allowedcompany)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SystemUserGroup{" + "id=" + id + ", username=" + username + ", groupname=" + groupname + ", allowedcompany=" + allowedcompany + '}';
    }
   
    
}
