package com.yi.du.dao;

import com.yi.du.bean.Moments;
import com.yi.du.bean.Praise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Repository
public interface MomentsDao {

    int insert(Moments moments);

    int deleteById(Long id);

    int updateById(Moments moments);

    List<Moments> selectByCondition();

    Moments selectPraiseSum(Integer moments_id);
}
