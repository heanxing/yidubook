package com.yi.du.controller;

import com.yi.du.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/3/26.
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    public String login(HttpServletRequest request) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (StringUtils.isEmpty(username)) {
                return "username is null";

            }
            if (StringUtils.isEmpty(password)) {
                return "password is null";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}