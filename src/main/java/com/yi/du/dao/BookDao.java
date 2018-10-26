package com.yi.du.dao;

import com.yi.du.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Repository
public interface BookDao {
    int insert(Book book);//插入书本

    int insertSelective(Book book);

    Book selectById(Long id);//通过id查询书本

    Book selectByBookid(Long bookid);

    Book selectByBookname(String bookName);

    Book selectByPicUrl(String PicUrl);

    List<Book> selectBySortId(Long sid);


    List<Book> selectByCondition(Book book);

    int updateById(Book book);//根据id修改书本

    int deleteById(Long id);//通过id对书本进行删除

    int updateByIdSelective(Book book);

    List<Book> selectByList();//查询所有书本

    List<Book> selectByBookName(Book book);//通过书本查询信息




}
