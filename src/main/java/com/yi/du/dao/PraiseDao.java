package com.yi.du.dao;

import com.yi.du.bean.Moments;
import com.yi.du.bean.Praise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PraiseDao {

    int insert(Praise praise);

    int updateById(Praise praise);

    Praise selectById(@Param("user_id") Integer user_id, @Param("moments_id")Integer moments_id);

    Praise selectById1(Integer moments_id);

    int deleteById(@Param("user_id") Integer user_id, @Param("moments_id")Integer moments_id);

    Praise selectPraiseSum(Integer moments_id);

}
