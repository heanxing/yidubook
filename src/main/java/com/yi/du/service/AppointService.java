package com.yi.du.service;

import com.yi.du.bean.Appoint;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */
public interface AppointService {

    int insert(Appoint appoint);//插入书本

    int insertSelective(Appoint appoint);

    Appoint selectById(Long id);//通过id查询书本


    List<Appoint> selectByCondition(Appoint appoint);

    List<Appoint> selectByStatus(Integer status);

    List<Appoint> selectUserId (Long User_id);//通过userId查询书本

    int updateById(Appoint appoint);//根据id修改书本

    int deleteById(Long id);//通过id对书本进行删除

    List <Appoint> updateByIdSelective(Appoint appoint);



}
