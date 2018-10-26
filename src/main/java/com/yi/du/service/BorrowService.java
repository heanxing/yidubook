package com.yi.du.service;

import com.yi.du.bean.Borrow;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface BorrowService {
    int insert(Borrow borrow);

    int insertSelective(Borrow borrow);//选择性插入

    Borrow selectById(Long id);

    List<Borrow> selectByStatus(Long User_id);

    List<Borrow> selectBorrow (Long User_id);//通过sid查询书本

    List<Borrow> selection(Long User_id);


    List<Borrow> selectBySuccess(Long User_id);

//    Student selectByName(String name);

    List<Borrow> selectByCondition(Borrow borrow);//选择性查询

    int updateById(Borrow borrow);//通过id进行修改

//    int updateByIdSelective(Borrow borrow);//通过选择性修改

    List <Borrow> updateByIdSelective(Borrow borrow);//通过id选择性修改

    int deleteById(Borrow borrow);//通过id进行删除
}
