package com.yi.du.service.impl;

import com.yi.du.bean.Praise;
import com.yi.du.dao.PraiseDao;
import com.yi.du.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    PraiseDao praiseDao;

    @Override
    public int insert(Praise praise) {
        return praiseDao.insert(praise);
    }

    @Override
    public int updateById(Praise praise) {
        return praiseDao.updateById(praise);
    }

    @Override
    public Praise selectById(Integer user_id, Integer moments_id) {
        return praiseDao.selectById(user_id,moments_id);
    }


    @Override
    public Praise selectById1(Integer moments_id) {
        return praiseDao.selectById1(moments_id);
    }

    @Override
    public int deleteById(Integer user_id,Integer moments_id) {
        return praiseDao.deleteById(user_id,moments_id);
    }

    @Override
    public Praise selectPraiseSum(Integer moments_id) {
        return praiseDao.selectPraiseSum(moments_id);
    }
}
