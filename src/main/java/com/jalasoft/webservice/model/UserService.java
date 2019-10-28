/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.model;

import com.jalasoft.webservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.model
 */
@Service
public class UserService {
    @Autowired //dependency inyection
    UserRepository userRepository;

    public Optional<User> getUser(Integer id) {return userRepository.findById(id);}

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user){ userRepository.save(user);}

    public User getUserByUserName(String userName){ return userRepository.findByUserName(userName);}
}
