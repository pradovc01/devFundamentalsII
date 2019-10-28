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

    /***
     * Constructor
     * @param title
     * @param description
     * @param steps
     */
    public TestCase(String title, String description, String steps){
        super();
        this.id = null;
        this.title = title;
        this.description = description;
        this.steps = steps;
    }

    /***
     * Get Id
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set Id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /***
     * Get Title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /***
     * Set Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get Description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /***
     * Set Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * Get Steps
     * @return
     */
    public String getSteps() {
        return steps;
    }

    /***
     * Set Steps
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
    }

    /***
     * Override toString method
     * @return
     */
    @Override
    public String toString(){
        return String.format("TestCase{id= %s, title='%s', description='%s', steps='%s'}",
                id, title, description, steps);
    }
}
