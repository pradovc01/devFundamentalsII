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

    public Optional<TestCase> getTestCase(Integer id){
        return testCaseRepository.findById(id);
    }

    public TestCase getTestCaseByTitle(String title){
        return testCaseRepository.findByTitle(title);
    }

    public List<TestCase> getAllTestCases(){
        List<TestCase> testcases = new ArrayList<>();
        testCaseRepository.findAll().forEach(testcases::add);
        return testcases;
    }

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

    public void deleteTestCase(Integer id){
        TestCase currentTestCase =  testCaseRepository.findById(id).orElse(null);
        if(currentTestCase != null){
            testCaseRepository.delete(currentTestCase);
        }
    }

    public TestCase getOneTestCaseById(Integer id){
        return testCaseRepository.findById(id).orElse(null);
    }

    public void addTestCase(TestCase testcase){
        testCaseRepository.save(testcase);
    }
}
