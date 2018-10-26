package com.yi.du.controller;

import com.yi.du.bean.Student;
import com.yi.du.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/2/26.
 */
@RestController
@RequestMapping("/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public Map <String, Object> get() {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Student student=new Student();
            List <Student> students =studentService.selectByCondition(student);


            param.put("list", students);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;
    }
    @PostMapping("delectTest")
    public Map <String, Object> delectTest(@RequestParam Long id) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Student student = new Student();
            student.setId(id);
//            student.setUsername(student.getUsername());
//            student.setPassword(student.getPassword());
            if (studentService.delectById(student) > 0) {
                result = true;
                msg = "删除成功";
                param.put("id", student.getId());
//                param.put("username",student.getUsername());
//                param.put("password",student.getPassword());

            } else {
                msg = "删除失败";
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }

    //修改接口
    @PostMapping("updateTest")
    public Map <String, Object> updateTest(@RequestParam Long id,@RequestParam String username,@RequestParam String password) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Student student = new Student();
            student.setId(id);
            student.setUsername(username);
            student.setPassword(password);
            if (studentService.updateById(student)>0){
                result=true;
                msg="修改成功";
                param.put("username",student.getUsername());
                param.put("password",student.getPassword(password));

            } else {
                msg = "修改失败";
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        param.put("result", result);
        param.put("msg", msg);
        return param;
    }


    //增加接口
    @PostMapping("insertTest")
    public Map <String, Object> insertTest(@RequestParam String username, @RequestParam String password) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();

        try {
            Student student = new Student();
            student.setUsername("xxx");
            student.setPassword("123456");


//            Book bookName("学科杂志2018");
//            boook = new Book();
//            book.setBok.setAuthor("xx出版社");
//            book.setPicUrl("/image/pic01.jpg");

            if (studentService.insert(student) > 0) {
                result = true;
                msg = "添加成功";
                param.put("id", student.getId());
            } else {
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
    //  ****************登录接口 *********************


    @PostMapping("login")

    public Map <String, Object> login(@RequestParam String username, @RequestParam String password) {
        boolean result = false;
        String msg = "";
        Long studentid =null;

         Map <String, Object> param = new HashMap <String, Object>();
        Student user=null;
        try {
            int sqlResult = 0;
             user = studentService.selectByName(username);
//            if (user != null && user.getPassword(password).equals(password.trim())) sqlResult = 1;
            if(user!=null&&user.getPassword(password).equals(password.trim())) sqlResult=1;
            if (sqlResult > 0) {
                result = true;
                msg = "登录成功";
            } else {
                msg = "账号或密码错误";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "登录出错";
        }


        param.put("result", result);
        param.put("msg", msg);
        param.put("userID",user.getId());
        return param;
    }







    //  ****************注册接口 *********************
    @PostMapping("/register")
    public Map <String, Object> register( @RequestParam String username, @RequestParam String password) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Student student=new Student();
            student.setUsername(username);
            student.setPassword(password);
            if (studentService.insert(student)>0){
                result = true;
                msg = "注册成功";
//                param.put("username",student.getUsername());
//                param.put("password",student.getPassword());

            } else {
                msg = "注册失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "注册出错";
        }
        param.put("result", result);
        param.put("msg", msg);
        return param;


            }
//
//
//  ****************修改密码接口 *********************
    @PostMapping("modifi")
    public Map <String, Object> modifi(@RequestParam Long id,@RequestParam String password) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
      try {
          Student student = new Student();

          student.setId(id);

          student.setPassword(password);
          if (studentService.updateById(student)>0){
              result=true;
              msg="修改密码成功";
          }else {
              msg="修改密码错误";
          }
      }catch (Exception e){
          e.printStackTrace();
      }
      param.put("result",result);
      param.put("msg",msg);
        return  param;
    }

    @GetMapping("batchUpdateTest")
    public  Map<String,Object>batchUpdateTest(@RequestParam Long id,@RequestParam String username,@RequestParam String password){
        boolean result=false;
        String msg="";
        Map<String,Object> param=new HashMap<String, Object>();
        List<Student> list = new ArrayList <Student>();
        try {
            Student student=new Student();
            student.setId(id);
            student.setUsername(username);
            student.setPassword(password);
            if (studentService.batchUpdate(list)>0){
                result=true;
                msg="批量更新成功";
            }else {
                msg="批量更新失败";
            }


            }catch (Exception e){
            e.printStackTrace();
            msg="批量修改出错";
        }
        param.put("result",result);
        param.put("msg",msg);
        return param;

        }



        @RequestMapping("/export")
        @ResponseBody
        public  String export(HttpServletResponse response) {
            response.setContentType("application/binary:charset=UTF-8");
            try {
                ServletOutputStream out = response.getOutputStream();//输出字节流
                //fileName返回Strin类型
                String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))

                        .getBytes(), "UTF-8");
                //设置文件的类型与表头的名称
                response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");
                String[] titles = {"学生编号", "用户名", "密码"};
                studentService.export(titles, out);
                return "success";

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "导出信息失败";
        }




    }








