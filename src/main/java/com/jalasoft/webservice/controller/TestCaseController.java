/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.controller;

/**
 * @author Veronica Prado on 10/24/2019
 * @package com.jalasoft.webservice.controller
 */

import com.jalasoft.webservice.entities.TestCase;
import com.jalasoft.webservice.model.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jalasoft.webservice.utils.Constants.TESTCASE_PATH;

/***
 * Implement the Rest endpoint to Manage information about Test Cases
 */
@RestController
@RequestMapping(TESTCASE_PATH)
public class TestCaseController {
    @Autowired
    private TestCaseService testcase;

    @GetMapping("/Id/{id:.+}")
    public TestCase getTestCase(@PathVariable("id") Integer testcaseId) {
        return testcase.getOneTestCaseById(testcaseId);
    }

    @GetMapping(value = "/testcases")
    public List<TestCase> getAllTestCases() {
        return testcase.getAllTestCases();

    }

    @PostMapping(value = "/testcase")
    public TestCase addTestCase(@RequestBody TestCase testCase) {
        testcase.addTestCase(testCase);
        return testcase.getTestCaseByTitle(testCase.getTitle());
    }

    @PutMapping(value = "/Id/{id:.+}")
    public TestCase updateTestCase(@RequestBody TestCase testcaseToUpdate, @PathVariable("id") Integer testcaseId) {
        TestCase updateTc = testcase.updateTestCase(testcaseToUpdate, testcaseId);
        return updateTc;
    }

    @DeleteMapping(value = "/Id/{id:.+}")
    public void deleteTestCase(@PathVariable("id") Integer testcaseId) {
        testcase.deleteTestCase(testcaseId);
    }
}
