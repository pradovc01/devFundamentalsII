/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.entities
 */
public class Cache {
    private static Cache cache;
    private static List<String> tokens;

    private Cache() {tokens = new ArrayList<>();
    }
    public static List<String> getTokens() {
        return tokens;
    }

    public static void setTokens(List<String> tokens) {
        Cache.tokens = tokens;
    }

    public static Cache getInstance(){
        if(cache == null) {cache = new Cache(); }
        return cache;
    }

    public void add(String token){
        tokens.add(token);
    }

    public boolean isValid(String token){
        return tokens.contains(token);
    }
}
