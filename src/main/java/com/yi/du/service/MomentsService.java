package com.yi.du.service;

import com.yi.du.bean.Moments;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface MomentsService {

    int insert(Moments moments);

    int deleteById(Long id);

    int updateById(Moments moments);

    List<Moments> selectByCondition();

    Moments selectPraiseSum(Integer moments_id);
}
