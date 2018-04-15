package com.jian.buyms.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_users"
)

public class Users  implements java.io.Serializable {


    // Fields    

     private String id;
     private String username;
     private String password;
    /** default constructor */
    public Users() {
    }

	/** minimal constructor */
    public Users(String id) {
        this.id = id;
    }

    @Id 
    
    @Column(name="ID", unique=true, nullable=false, length=32)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="USERNAME", length=100)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="PASSWORD", length=200)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   








}