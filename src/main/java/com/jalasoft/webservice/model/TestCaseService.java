/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.model;

import com.jalasoft.webservice.entities.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Veronica Prado on 10/24/2019
 * @package com.jalasoft.webservice.model
 */

@Service
public class TestCaseService {
    @Autowired //dependency inyection
    TestCaseRepository testCaseRepository;

    /***
     * Get test case by Id in database
     * @param id
     * @return
     */
    public Optional<TestCase> getTestCase(Integer id){
        return testCaseRepository.findById(id);
    }

    /***
     * Get test case by Title
     * @param title
     * @return
     */
    public TestCase getTestCaseByTitle(String title){
        return testCaseRepository.findByTitle(title);
    }

    /***
     * Get Test cases
     * @return
     */
    public List<TestCase> getAllTestCases(){
        List<TestCase> testcases = new ArrayList<>();
        testCaseRepository.findAll().forEach(testcases::add);
        return testcases;
    }

    /***
     * Update a test case
     * @param testCase
     * @param id
     * @return
     */
    public TestCase updateTestCase(TestCase testCase, Integer id){
        TestCase currentTestCase =  testCaseRepository.findById(id).orElse(null);
        if(currentTestCase != null){
            currentTestCase.setTitle(testCase.getTitle());
            currentTestCase.setDescription(testCase.getDescription());
            currentTestCase.setSteps(testCase.getSteps());
            currentTestCase = testCaseRepository.save(currentTestCase);
        }

        return currentTestCase;
    }

    /***
     * Delete a Testcase
     * @param id
     */
    public void deleteTestCase(Integer id){
        TestCase currentTestCase =  testCaseRepository.findById(id).orElse(null);
        if(currentTestCase != null){
            testCaseRepository.delete(currentTestCase);
        }
    }

    /***
     * Get test Case, if test case doesn't exist return null
      * @param id
     * @return
     */
    public TestCase getOneTestCaseById(Integer id){
        return testCaseRepository.findById(id).orElse(null);
    }

    /***
     * Add new TestCase
     * @param testcase
     */
    public void addTestCase(TestCase testcase){
        testCaseRepository.save(testcase);
    }
}
