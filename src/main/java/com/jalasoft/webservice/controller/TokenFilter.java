/*
 * Copyright (c) 2019 Jalasoft.
 *
 *   This software is the confidential and proprietary information of Jalasoft.
 *    ("Confidential Information"). You shall not  disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into  with Jalasoft.
 */

package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.entities.Cache;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.jalasoft.webservice.utils.Constants.*;

/**
 * @author Veronica Prado on 10/27/2019
 * @package com.jalasoft.webservice.controller
 */
@WebFilter(urlPatterns = {"/*"})
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURL().toString();
        String auth = req.getHeader(AUTHORIZATION);
        String token = null;
        if (auth != null) {
            token = auth.split(" ")[1];
        }

        if (url.contains(LOGIN_PATH) || Cache.getInstance().isValid(token)) {
            chain.doFilter(request, response);
        } else {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
        }
    }

    @Override
    public void destroy() {

    }
}
