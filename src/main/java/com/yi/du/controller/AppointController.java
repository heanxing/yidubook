package com.yi.du.controller;

import com.yi.du.bean.Appoint;
import com.yi.du.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/28.
 */

@RestController
@RequestMapping("/api/Appoint")
public class AppointController {

    @Autowired
    private AppointService appointService;



    @GetMapping("/get")//查询所有借书预约成功表
    public Map<String, Object> get() {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Appoint appoint = new Appoint();
            List <Appoint> appoints = appointService.selectByCondition(appoint);
            param.put("list", appoints);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询出错");
        }
        return param;

    }
    @PostMapping("/selectUserId")
    public  List <Appoint> selectUserId (@RequestParam Long user_id ){

        try {
            return appointService.selectUserId(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败");

        }
        return null;
    }

    //预约操作
 @PostMapping("appointSuccess")
    public Map <String, Object>
    appointSuccess(@RequestParam Long User_id,@RequestParam Long B_id, @RequestParam String Stime, @RequestParam String Htime,@RequestParam Integer status) {
        boolean result = false;
        String msg = "";

        Map <String, Object> param = new HashMap <String, Object>();
        try {
                    Appoint appoint=new Appoint();
                    appoint.setUser_id(User_id);
                    appoint.setB_id(B_id);
                    appoint.setStime(Stime);
                    appoint.setHtime(Htime);
                    appoint.setStatus(status);

                if (appointService.insert(appoint)>0){
                    result=true;
                    msg="预约成功";
                }else {
                    msg="预约失败";
                }
        }catch (Exception e){
            e.printStackTrace();
            msg="预约出错";
        }

        param.put("result", result);
        param.put("msg", msg);

         return  param;
        }



        //取消预约
        @PostMapping("delectTest")
    public Map <String, Object> delectTest(@RequestParam Long id) {
        boolean result = false;
        String msg = "";
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            Appoint appoint = new Appoint();
            appoint.setId(id);
//            student.setUsername(student.getUsername());
//            studen996+
//
// t.setPassword(student.getPassword());
            if (appointService.deleteById(id)>0) {
                result = true;
                msg = "删除成功";
                param.put("id", appoint.getId());
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


    @GetMapping("/selectByStatus")
    public Map <String, Object> selectByStatus(@RequestParam Integer status) {
        Map <String, Object> param = new HashMap <String, Object>();
        try {
            List<Appoint> appoints=appointService.selectByStatus(status);
            param.put("list",appoints);

        }catch (Exception e){
            e.printStackTrace();
        }
        return param;

    }




}
