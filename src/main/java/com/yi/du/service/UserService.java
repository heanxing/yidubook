package com.yi.du.service;

import com.yi.du.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2018/4/7.
 */

public interface UserService {
    User selectByName(String name);

    List<User>selectList();


    List<User> selectByCondition(User user);//选择性查询
}
