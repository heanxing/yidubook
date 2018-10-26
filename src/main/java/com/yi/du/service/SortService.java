package com.yi.du.service;

import com.yi.du.bean.Sort;

import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
public interface SortService {
/*
返回所有种类信息
* */


    int insert(Sort sort);

    int insertSelective(Sort sort);//选择性插入

    Sort selectById(Long id);

   Sort selectByPicUrl(String PicUrl);
    List<Sort> selectByExample(Sort sort);

    List<Sort> selectByCondition(Sort sort);//选择性查询

    int updateById(Sort sort);//通过id进行修改

    int updateByIdSelective(Sort sort);//通过id选择性修改
    List<Sort> selectByList();//查询所有书本

    int deleteById(Long id);//通过id进行删除
}
