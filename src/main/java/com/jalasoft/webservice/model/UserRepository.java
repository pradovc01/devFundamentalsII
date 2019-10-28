/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.model;

import com.jalasoft.webservice.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.model
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
