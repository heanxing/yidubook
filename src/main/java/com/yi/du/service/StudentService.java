package com.yi.du.service;

import com.yi.du.bean.Student;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface StudentService {

    int insert(Student student);

    int insertSelective(Student student);

    Student selectById(Long id);

    Student selectByName(String name);

    List<Student> selectByCondition(Student student);

    int updateById(Student student);

    int updateByIdSelective(Student student);

    int delectById(Student student);

    int batchUpdate(List<Student> students);//通过id进行批量修改

    public void export(String[] titles, ServletOutputStream out) throws Exception;//



}
