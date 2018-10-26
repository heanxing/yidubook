package com.yi.du.service.impl;

import com.yi.du.dao.LoginDao;
import com.yi.du.bean.User;
import com.yi.du.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/26.
 */
@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Override
    public User login() {
        return loginDao.login();
    }
}
