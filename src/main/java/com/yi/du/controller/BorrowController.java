package com.yi.du.controller;

import com.yi.du.bean.Appoint;
import com.yi.du.bean.Book;
import com.yi.du.bean.Borrow;
import com.yi.du.service.AppointService;
import com.yi.du.service.BookService;
import com.yi.du.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/1.
 */
@RestController
@RequestMapping("/api/Borrow")
public class BorrowController {
    @Autowired
     private  BorrowService borrowService;
    @Autowired
     private BookService bookService;
    @Autowired
    private AppointService appointService;



//查询所有信息
    @GetMapping("/get")
    public Map <String, Object> get() {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Borrow borrow=new Borrow();

         List<Borrow> borrows=borrowService.selectByCondition(borrow);
            param.put("list", borrows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;
    }


    @PostMapping("/selection")
    public List<Borrow>  selection(@RequestParam Long User_id) {
       // Map <String, Object> param = new HashMap <String, Object>();
        try {

             return borrowService.selection(User_id);
           // param.put("list", borrows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @PostMapping("/selectByStatus")
    public List<Borrow> selectByStatus(@RequestParam Long User_id) {
        try {


             return borrowService.selectByStatus(User_id);

       //     param.put("list",borrows);

        }catch (Exception e){
            e.printStackTrace();
        }
       return null;

    }



    @PostMapping("/selectBySuccess")
    public List<Borrow> selectBySuccess(@RequestParam Long User_id) {
        try {

             return borrowService.selectBySuccess(User_id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }





    @PostMapping("/result")
    public Map <String, Object> result(@RequestParam Long id) {
        Map <String, Object> param = new HashMap <String, Object>();
        boolean result=false;
        String msg="";
        try {
          Borrow borrow=borrowService.selectById(id);
            if (borrow.getStatus().intValue()==1){//intValue  把Integer转int
                result=true;
                msg="还书成功";
            }else {
                msg="还书失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg="还书出错";
        }

        param.put("result",result);
        param.put("msg",msg);

        return param;
    }





    @PostMapping("/selectBorrow")

    public Map <String, Object> selectBorrow(@RequestParam Long user_id) {
        Map <String, Object> param = new HashMap <String, Object>();
        Borrow borrow=null;
        try {

            List<Borrow> borrows=borrowService.selectBorrow(user_id);
            param.put("list",borrows);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");

        }
        return param;
    }

    /*
    **借书
    * */
    @PostMapping("insertTest")
    public String insertTest(@RequestParam long User_id,@RequestParam Long book_Id,@RequestParam String Br_start,@RequestParam String Br_stop,
                             @RequestParam Integer status) {

        Book book = bookService.selectByBookid(book_Id);
        book.setMount(book.getMount() - 1);
        Appoint appoint=new Appoint();
        if (bookService.updateById(book) > 0) {
            Borrow borrow = new Borrow();
           borrow.setUser_id(User_id);
           borrow.setBook_Id(book_Id);
           borrow.setBr_start(Br_start);
           borrow.setBr_stop(Br_stop);
           borrow.setStatus(status);
           borrowService.insert(borrow);
        }

        return "success";
    }



    /*续借功能*/
    @PostMapping("updateTest")
    public Map <String, Object> updateTest(@RequestParam Long id,@RequestParam  String Br_stop,@RequestParam Integer status ) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Borrow borrow=new Borrow();
            borrow.setId(id);
            borrow.setBr_stop(Br_stop);
            borrow.setStatus(status);

            if (borrowService.updateById(borrow)>0) {
                result = true;
                msg = "续借成功";


            }else {
                msg="续借失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "续借出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }


    @PostMapping("returnTest")
    public String returnTest(@RequestParam Long id,@RequestParam Long book_Id,@RequestParam String Br_stop) {

        Book book = bookService.selectByBookid(book_Id);
        book.setMount(book.getMount() + 1);
        if (bookService.updateById(book) > 0) {
            Borrow borrow = new Borrow();
            borrow.setId(id);
            borrow.setStatus(1);
            borrow.setBr_stop(Br_stop);
            borrowService.updateById(borrow);
        }

        return "success";
    }



    @PostMapping ("deleteTest")
    public Map <String, Object> deleteTest(@RequestParam Long id ) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Borrow borrow=new Borrow();
           borrow.setId(id);

            if (borrowService.deleteById(borrow)>0) {
                result = true;
                msg = "删除成功";

            }else {
                msg="删除失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "删除出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }












}


