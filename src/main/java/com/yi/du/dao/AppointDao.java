package com.yi.du.dao;

import com.yi.du.bean.Appoint;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */
@Repository
public interface AppointDao {

    int insert(Appoint appoint);//插入书本

    int insertSelective(Appoint appoint);

   Appoint selectById(Long id);//通过id查询书本

    List<Appoint> selectUserId(Long User_id);


    List<Appoint> selectByCondition(Appoint appoint);

    List<Appoint> selectByStatus(Integer status);


    int updateById(Appoint appoint);//根据id修改书本

    int deleteById(Long id);//通过id对书本进行删除

    int updateByIdSelective(Appoint appoint);
}
