package com.yi.du.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi.du.bean.Msg;
import com.yi.du.bean.Sort;
import com.yi.du.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/2/28.
 */
@RestController
@RequestMapping("/api/Sort")
public class SortController {
    @Autowired
     private SortService sortService;
    /*
返回所有种类信息
* */




    //查询分页
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    @ResponseBody
    public Msg selectList(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn,5);
        List <Sort> sorts =sortService.selectByList();
        PageInfo page=new PageInfo(sorts,5);

        return Msg.success().add("sort",page);
    }






    @GetMapping("/sort")

    public List <Sort> getSort(){
        Sort sort=new Sort();
        List<Sort> list=sortService.selectByExample(sort);
        return list;

    }






    @GetMapping("/get")
    public Map<String, Object> get() {
        Map <String, Object> param = new HashMap<String, Object>();
        try {
            Sort sort=new Sort();
            List <Sort> sorts=sortService.selectByCondition(sort);
            param.put("list", sorts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;
    }
    //通过id进行查询数据


    @GetMapping("/getSort")
    public Map<String, Object>getSort(@RequestParam long id) {
        Map <String, Object> param = new HashMap<String, Object>();
        try {
            Sort sort=sortService.selectById(id);
            sort.getSname();
             sort.getImage();
          param.put("list",sort);

        }catch (Exception e){
            e.printStackTrace();
        }
        return param;

        }






    @PostMapping("deleteTest")
    public Map <String, Object> deleteTest(@RequestParam Long id) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            if (sortService.deleteById(id) > 0) {
                result = true;
                msg = "删除成功";


            } else {
                msg = "删除失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "删除出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }

    //修改接口
    @PostMapping("updateTest")
    public Map <String, Object> updateTest(@RequestParam Long id, @RequestParam String sname,@RequestParam String image) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Sort sort=new Sort();
            sort.setId(id);
            sort.setSname(sname);
            sort.setImage(image);

            if (sortService.updateById(sort) > 0) {
                result = true;
                msg = "修改成功";
                param.put("id", sort.getId());
//                param.put("username",student.getUsername());
//                param.put("password",student.getPassword());

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
    public Map <String, Object> insertTest(@RequestParam String sname, @RequestParam String image) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();

        try {
//            Book book = new Book();
////            book.setBookName(book.getBookName());
////            book.setAuthor(book.getAuthor());
////            book.setPicUrl(book.getPicUrl());
//
//            book.setBookName("学科杂志2018");
//            book.setAuthor("xxchubanshe");
//            book.setPicUrl("/image/pic01.jpg");
            Sort sort=new Sort();
            sort.setSname(sname);
            sort.setImage(image);

            if (sortService.insert(sort) > 0) {
                result = true;
                msg = "添加成功";

            }else {
                msg = "添加失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "添加出错";
        }

        param.put("result", result);
        param.put("msg", msg);
        return param;
    }


    @PostMapping("/uploade")
    public Map<String,Object> register(@RequestParam("image") CommonsMultipartFile file,@RequestParam(value = "sname",required = false) String sname) throws Exception{
        System.out.println("file: " + file);
        boolean result=false;
        String msg="";
        Map<String ,Object> param=new HashMap<String,Object>();
        String realPath="C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\PROJECT\\com.zhouyue\\image";
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
            Sort sort=new Sort();
            sort.setSname(sname);
//            sort.setImage("/image/"+filename);
            if (sortService.insert(sort)>0){
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
