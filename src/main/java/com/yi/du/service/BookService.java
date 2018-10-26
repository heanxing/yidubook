package com.yi.du.service;

import com.yi.du.bean.Book;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface BookService {
    int insert(Book book);

    int insertSelective(Book book);

    Book selectById(Long id);

    Book selectByBookid(Long bookid);

    Book selectByBookname(String bookName);

    Book selectByPicUrl(String PicUrl);




    List<Book> selectBySortId (Long sid);//通过sid查询书本


    List<Book> selectByCondition(Book book);

    int updateById(Book book);

    int updateByIdSelective( Book book);

    int deleteById(Long id);
    List<Book> selectByList();//查询所有书本


    List<Book> selectByBookName(Book book);//通过书本查询信息

}
