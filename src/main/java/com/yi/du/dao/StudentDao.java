package com.yi.du.dao;

import com.yi.du.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Repository
public interface StudentDao {


    int insert(Student student);

    int insertSelective(Student student);//选择性插入

    Student selectById(Long id);

    Student selectByName(String name);

    List<Student> selectByCondition(Student student);//选择性查询

    int updateById(Student student);//通过id进行修改

    int updateByIdSelective(Student student);//通过id选择性修改

    int deleteById(Student student);//通过id进行删除

    List<Student> batchUpdate(List<Student> students);//通过id进行批量修改

    List<Student> query();//导Exel出数据







}
