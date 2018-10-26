package com.yi.du.dao;

import com.yi.du.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/7.
 */
@Repository
public interface UserDao {
    User selectByName(String name);
    List<User>selectList();

    List<User> selectByCondition(User user);//选择性查询
}
