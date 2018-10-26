package com.yi.du.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi.du.bean.User;
import com.yi.du.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/7.
 */

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")//查询所有借书预约成功表
    public Map <String, Object> get() {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            User user1 = new User();
            List <User> users = userService.selectByCondition(user1);
            param.put("list", users);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询出错");
        }
        return param;


    }







    @PostMapping("login")

    public Map <String, Object> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        boolean result = false;
        String msg = "";
        Long studentid =null;

        Map <String, Object> param = new HashMap <String, Object>();
        User user=null;
        HttpSession session=request.getSession();

        try {
            int sqlResult = 0;
                user=userService.selectByName(username);
            if(user!=null&&user.getPassword(password).equals(password.trim())) sqlResult=1;
            if (sqlResult > 0) {
            result = true;
            msg = "登录成功";
            session.setAttribute("username",user.getUsername());
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

    @GetMapping("exit")
    public  String ExitSession(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/login.jsp");

        return "操作成功";

    }

    //查询分页
    @RequestMapping(value = "/selectList", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo <User> selectList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
                                      @RequestParam(required=false,defaultValue="1") Integer pageSize) {


        PageHelper.startPage(pageNo, pageSize);
        List <User> users = userService.selectList();
        PageInfo <User> page = new PageInfo <User>(users);

        return page;

    }


}
