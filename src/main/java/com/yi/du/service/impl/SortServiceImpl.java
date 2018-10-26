package com.yi.du.service.impl;

import com.yi.du.dao.SortDao;
import com.yi.du.bean.Sort;
import com.yi.du.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service
public class SortServiceImpl implements SortService {
    @Autowired
    SortDao sortDao;

    @Override
    public int insert(Sort sort) {
        return sortDao.insert(sort);
    }
    @Override
    public int insertSelective(Sort sort) {
        return sortDao.insertSelective(sort);
    }
    @Override
    public Sort selectById(Long id) {
        return sortDao.selectById(id);
    }
    @Override
    public Sort selectByPicUrl(String PicUrl) {
        return sortDao.selectByPicUrl(PicUrl);
    }
    @Override
    public List <Sort> selectByExample(Sort sort) {
        return sortDao.selectByExample(sort);
    }
    @Override
    public List <Sort> selectByCondition(Sort sort) {
        return sortDao.selectByCondition(sort);
    }
    @Override
    public int updateById(Sort sort) {
        return sortDao.updateById(sort);
    }
    @Override
    public int updateByIdSelective(Sort sort) {
        return sortDao.updateByIdSelective(sort);
    }
    @Override
    public List <Sort> selectByList() {
        return sortDao.selectByList();
    }

    @Override
    public int deleteById(Long id) {
        return sortDao.deleteById(id);
    }
}
