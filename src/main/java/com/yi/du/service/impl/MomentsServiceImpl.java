package com.yi.du.service.impl;

import com.yi.du.dao.MomentsDao;
import com.yi.du.bean.Moments;
import com.yi.du.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class MomentsServiceImpl implements MomentsService {

    @Autowired
    MomentsDao momentsDao;

    @Override
    public int insert(Moments moments) {
        return momentsDao.insert(moments);
    }

    @Override
    public int deleteById(Long id) {
        return momentsDao.deleteById(id);
    }

    @Override
    public int updateById(Moments moments) {
        return momentsDao.updateById(moments);
    }

    @Override
    public List <Moments> selectByCondition() {
        return momentsDao.selectByCondition();
    }

    @Override
    public Moments selectPraiseSum(Integer moments_id) {
        return momentsDao.selectPraiseSum(moments_id);
    }
}
