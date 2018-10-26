package com.yi.du.service.impl;

import com.yi.du.dao.BorrowDao;
import com.yi.du.bean.Borrow;
import com.yi.du.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowDao borrowDao;

    @Override
    public int insert(Borrow borrow) {
        return borrowDao.insert(borrow);}
    @Override
    public int insertSelective(Borrow borrow) {
        return borrowDao.insertSelective(borrow);
    }
    @Override
    public Borrow selectById(Long id) {
        return borrowDao.selectById(id);
    }
    @Override
    public List <Borrow> selectByStatus(Long User_id) {
        return borrowDao.selectByStatus(User_id);
    }

    @Override
    public List <Borrow> selectByCondition(Borrow borrow) {
        return borrowDao.selectByCondition(borrow);
    }
    @Override
    public List<Borrow> selectBorrow(Long User_id) {
        return borrowDao.selectBorrow(User_id);
    }
    @Override
    public List <Borrow> selection(Long User_id) {
        return borrowDao.selection(User_id);
    }
    @Override
    public List <Borrow> selectBySuccess(Long User_id) {
        return borrowDao.selectBySuccess(User_id);
    }

    @Override
    public int updateById(Borrow borrow) {
        return borrowDao.updateById(borrow);
    }
    @Override
    public List <Borrow> updateByIdSelective(Borrow borrow) {
        return borrowDao.updateByIdSelective(borrow);
    }

    @Override
    public int deleteById(Borrow borrow) {
        return borrowDao.deleteById(borrow);
    }




}
