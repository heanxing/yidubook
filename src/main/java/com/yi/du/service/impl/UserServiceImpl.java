package com.yi.du.service.impl;

import com.yi.du.dao.UserDao;
import com.yi.du.bean.User;
import com.yi.du.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/7.
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserDao userDao;
    @Override
    public User selectByName(String name) {
        return  userDao.selectByName(name);
    }
    @Override
    public List <User> selectList() {
        return userDao.selectList();
    }
    @Override
    public List<User> selectByCondition(User user) {
        return userDao.selectByCondition(user);
    }
}
