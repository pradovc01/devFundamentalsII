/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.entities;

import javax.persistence.*;

/***
 * Class to manage information about TestCase
 */
@Entity
@Table(name="TestCase")
public class TestCase {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String steps;
    public TestCase(){

    }
    public TestCase(String title, String description, String steps){
        super();
        this.id = null;
        this.title = title;
        this.description = description;
        this.steps = steps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString(){
        return String.format("TestCase{id= %s, title='%s', description='%s', steps='%s'}",
                id, title, description, steps);
    }
}
