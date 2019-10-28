/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.database;

/**
 * @author Veronica Prado on 10/24/2019
 * @package com.jalasoft.webservice.database
 */

import com.jalasoft.webservice.entities.TestCase;
import com.jalasoft.webservice.entities.User;
import com.jalasoft.webservice.model.TestCaseRepository;
import com.jalasoft.webservice.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/***
 * Load Database which will load database with default values
 */
@Component
public class DatabaseLoader implements ApplicationRunner {
    private TestCaseRepository testcases;
    private UserRepository users;

    @Autowired
    public DatabaseLoader(TestCaseRepository testcases, UserRepository users){
        this.testcases = testcases;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //ArrayList<TestCase> testcaseList = new ArrayList<TestCase>();
        TestCase defaultTC = new TestCase("COMP: Verify Title is displayed in Top Bar",
                "This TC Verify if the screen' title is displayed on Top bar",
                "1. Open ORS page with correct user. 2. Navigate to .. menu");
        testcases.save(defaultTC);

        User admin = new User("admin", "admin", "administrator");
        users.save(admin);
    }

}
