package com.yi.du.service.impl;

import com.yi.du.dao.BookDao;
import com.yi.du.bean.Book;
import com.yi.du.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }
    @Override
    public int insertSelective(Book book) {
        return bookDao.insertSelective(book);
    }
    @Override
    public Book selectById(Long id) {
        return bookDao.selectById(id);
    }
    @Override
    public Book selectByBookid(Long bookid) {
        return bookDao.selectByBookid(bookid);
    }
    @Override
    public Book selectByBookname(String bookName) {
        return bookDao.selectByBookname(bookName);
    }
    @Override
    public Book selectByPicUrl(String PicUrl) {
        return bookDao.selectByPicUrl(PicUrl);
    }
    @Override
    public List<Book> selectBySortId(Long sid) {
        return bookDao.selectBySortId(sid);
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        return bookDao.selectByCondition(book);
    }
    @Override
    public int updateById(Book book) {
        return bookDao.updateById(book);
    }
    @Override
    public int updateByIdSelective(Book book) {
        return bookDao.updateByIdSelective(book);
    }


    @Override
    public int deleteById(Long id) {
        return bookDao.deleteById(id);
    }
    @Override
    public List <Book> selectByList() {
        return bookDao.selectByList();
    }
    @Override
    public List <Book> selectByBookName(Book book) {
        return bookDao.selectByBookName(book);
    }


}
