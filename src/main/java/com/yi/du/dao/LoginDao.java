package com.yi.du.dao;

import com.yi.du.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/26.
 */
public interface LoginDao {
    public User login();
}
