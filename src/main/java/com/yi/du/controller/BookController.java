package com.yi.du.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi.du.bean.Book;
import com.yi.du.bean.Msg;
import com.yi.du.service.BookService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/2/26.
 */
@RestController
@RequestMapping("/api/Book")
public class BookController  {
    @Autowired
    private BookService bookService;


    @RequestMapping(value ="selectById",method = RequestMethod.GET)
    @ResponseBody
    public Msg selectById(@RequestParam Long id){
        Book book=bookService.selectById(id);
        return Msg.success().add("book",book);
    }




        //查询分页
        @RequestMapping(value = "/selectList", method = RequestMethod.GET)
        @ResponseBody
    public Msg selectList(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
            PageHelper.startPage(pn,5);
            List <Book> books =bookService.selectByList();
            PageInfo page=new PageInfo(books,5);

        return Msg.success().add("pageInfo",page);
    }




    @GetMapping("/get")
    public Map <String, Object> get() {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
                Book book=new Book();
           List<Book> books=bookService.selectByCondition(book);
            param.put("lists", books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;
    }



    @PostMapping("selectByBookId")

    public Map <String, Object> selectByBookId(@RequestParam Long bookid) {
        Map <String, Object> param = new HashMap <String, Object>();

        Book book=null;
        try {
            book=bookService.selectByBookid(bookid);
            param.put("list",book);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");

        }
        param.put("BookId",book.getBookid());
        return param;
    }




    @PostMapping("selectByBookname")
    public Book selectByBookname(@RequestParam String bookName) {
        try {
            return bookService.selectByBookname(bookName);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");
        }
        return null;
    }





//通过sort_id进行查询所有的相同书本
    @PostMapping("/selectBook")

    public Map <String, Object> selectBook(@RequestParam Long sid) {
        Map <String, Object> param = new HashMap <String, Object>();
        Book books=null;
        try {

            List<Book> book=bookService.selectBySortId(sid);
            param.put("list",book);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");

        }
        return param;
    }





    @PostMapping("deleteTest")
    public Map <String, Object> deleteTest(@RequestParam Long id) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            if (bookService.deleteById(id) > 0) {
                result = true;
                msg = "下架成功";
//                param.put("username",student.getUsername());
//                param.put("password",student.getPassword());

            } else {
                msg = "下架失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "下架出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }

    //修改接口
    @PostMapping("updateTest")
    public Map <String, Object> updateTest(@RequestParam Long id, @RequestParam Long mount ) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Book book = new Book();
            book.setId(id);
            book.setMount(mount);
            if (bookService.updateById(book) > 0) {
                result = true;
                msg = "修改成功";
            } else {
                msg = "修改失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "修改出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }


    //增加接口
    @PostMapping("insertTest")
    public Map <String, Object> insertTest(@RequestParam Long bookid, @RequestParam Long sid,@RequestParam String bookName ,
                                           @RequestParam String author,@RequestParam String press,@RequestParam Long mount,
                                           @RequestParam String location,@RequestParam String picUrl) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();

        try {

            Book book = new Book();
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setPress(press);
            book.setMount(mount);
            book.setPicUrl(picUrl);
            book.setLocation(location);
            book.setSid(sid);
            book.setBookid(bookid);
//

            if (bookService.insert(book) > 0) {
                result = true;
                msg = "上架成功";

            }else {
                msg = "上架失败";

            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "上架出错";
        }

        param.put("result", result);
        param.put("msg", msg);
        return param;
    }

    @PostMapping("retunTest")
    public Map <String, Object> retunTest(@RequestParam Long id,@RequestParam Long mount) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Book book=new Book();

//            if (bookService.updateById(id)>0) {
//                result = true;
//                msg = "还书成功";
//            } else {
//                msg = "还书失败";
//                book.setId(id);
//                book.setMount(mount);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "还书出错";
        }
        param.put("relust", result);
        param.put("msg", msg);
        return param;
    }



    @PostMapping("bookaction")
    @ResponseBody
    public  String bookaction(HttpServletRequest request){
        String result="";
        try {
            //先获取参数
            String id=request.getParameter("id")==null?null:request.getParameter("id").trim();
            String openType=request.getParameter("openType")==null?null:request.getParameter("openType").trim();
            //1代表增加 2代表减少
            String mount =request.getParameter("mount")==null?null:request.getParameter("mount").trim();

            //再进行判断是否为空值
            if (StringUtils.isEmpty(id)){
                return  "id is null";

            }
            if (StringUtils.isEmpty(openType)){
                return  "openType is null";

            }
            if (StringUtils.isEmpty(mount)){
                return  "mount is null";

            }
            //先查询数据库
            Book book=bookService.selectById(Long.valueOf(id));


            if (Integer.parseInt(openType)==1){
                book.setMount(book.getMount()-Long.valueOf(mount));

            }else if (Integer.parseInt(openType)==2){
                book.setMount(book.getMount());
            }


            if (book.getMount()<=0){
                System.out.print("库存不足");
            }else {

                int target=bookService.updateByIdSelective(book);
                System.out.println("修改书本数量是否："+(target==1?"成功":"失败"));
            }




        }catch (Exception e){
            e.getMessage();
            return  result;
        }
        return  "success";
    }






    @PostMapping("/uploade")
    public Map<String,Object> register(@RequestParam("image") CommonsMultipartFile file,@RequestParam(value = "bookid",required = false) Long bookid,
                                       @RequestParam(value = "bookName",required = false) String bookName,
                                       @RequestParam(value = "author",required = false) String author,
                                       @RequestParam(value = "sid",required = false) Long sid,
                                       @RequestParam(value = "press",required = false) String press,
                                       @RequestParam(value = "mount",required = false) Long mount,
                                       @RequestParam(value = "location",required = false) String location
    ) throws Exception{
        System.out.println("file: " + file);
        boolean result=false;
        String msg="";
        Map<String ,Object> param=new HashMap<String,Object>();
        String realPath="image";
        File file1=new File(realPath);
        if (!file1.exists()){
            file1.mkdir();
        }
        String prefix= UUID.randomUUID().toString().replaceAll("-","");
        prefix=prefix.replace("-","");
        String filename=prefix+"_"+file.getOriginalFilename();
        InputStream inputStream=file.getInputStream();

        OutputStream outputStream=new FileOutputStream(new File(realPath+"\\"+filename));
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        try {
           Book book=new Book();
           book.setBookid(bookid);
           book.setBookName(bookName);
           book.setAuthor(author);
           book.setSid(sid);
           book.setMount(mount);
           book.setLocation(location);
           book.setPress(press);
           book.setPicUrl("/image/"+filename);

            if (bookService.insert(book)>0){
                result =true;
                msg="插入成功";
            }else {
                msg="插入失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            msg="插入出错";
        }
        param.put("result",result);
        param.put("msg",msg);
        return param;
    }



}



