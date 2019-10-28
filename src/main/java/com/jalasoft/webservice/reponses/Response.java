/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.reponses;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.reponses
 */
public class Response {
    private String name;
    private Integer status;
    private String detail;

    /**
     * Response Constructor
     *
     * @param name   Status in String Format.
     * @param status Status in Numeric Format.
     * @param detail Message String.
     */
    public Response(String name, Integer status, String detail) {
        this.name = name;
        this.status = status;
        this.detail = detail;
    }

    /**
     * Get Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get status
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Set status
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /***
     * Get detail
     * @return
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Set detail
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
