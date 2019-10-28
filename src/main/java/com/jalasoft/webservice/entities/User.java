/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.entities;

import javax.persistence.*;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.entities
 */
@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String role;
    public User(){

    }
    public User(String userName, String password, String role){
        super();
        this.id = null;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
