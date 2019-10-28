/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.entities.Cache;
import com.jalasoft.webservice.entities.User;
import com.jalasoft.webservice.model.UserService;
import com.jalasoft.webservice.reponses.ErrorResponse;
import com.jalasoft.webservice.reponses.LoginResponse;
import com.jalasoft.webservice.reponses.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jalasoft.webservice.utils.Constants.BASE_PATH;
import static com.jalasoft.webservice.utils.Constants.LOGIN_PATH;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.controller
 */
@RestController
@RequestMapping(BASE_PATH)
public class LoginController {
    @Autowired
    private UserService userservice;


    @PostMapping(value = LOGIN_PATH)
    public Response loginController(@RequestBody User user) {
        String privateKey = "dev-project";
        String ROLE = "role";
        User userAuth = userservice.getUserByUserName(user.getUserName());
        if (userAuth != null) {
            String key = privateKey;
            String token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .setSubject(user.getUserName())
                    .claim(ROLE, user.getRole())
                    .compact();

            //Add token to cache.
            Cache.getInstance().add(token);
            return new LoginResponse(HttpStatus.ACCEPTED.name(),
                    HttpStatus.ACCEPTED.value(),
                    String.format("Token for %s user successfully generated", user.getUserName()),
                    token);
        }
        else{
            return new ErrorResponse(HttpStatus.BAD_REQUEST.name(),
                    HttpStatus.BAD_REQUEST.value(),
                    "User invalid");

        }
    }
}
