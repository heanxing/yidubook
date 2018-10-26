package com.yi.du.service.impl;

import com.yi.du.dao.AppointDao;
import com.yi.du.bean.Appoint;
import com.yi.du.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */
@Service
public class AppointServiceImpl implements AppointService {

    @Autowired
    AppointDao appointDao;

    @Override
    public int insert(Appoint appoint) {
        return 0;
    }

    @Override
    public int insertSelective(Appoint appoint) {
        return appointDao.insertSelective(appoint);
    }

    @Override
    public Appoint selectById(Long id) {
        return appointDao.selectById(id);
    }

    @Override
    public List<Appoint> selectByCondition(Appoint appoint) {
        return appointDao.selectByCondition(appoint);
    }

    @Override
    public List <Appoint> selectByStatus(Integer status) {
        return appointDao.selectByStatus(status);
    }

    @Override
    public List<Appoint> selectUserId(Long User_id) {
        return appointDao.selectUserId(User_id);
    }

    @Override
    public List <Appoint> updateByIdSelective(Appoint appoint) {
        return appointDao.selectByCondition(appoint);
    }

    @Override
    public int updateById(Appoint appoint) {
        return appointDao.updateById(appoint);
    }

    @Override
    public int deleteById(Long id) {
        return appointDao.deleteById(id);
    }
}
