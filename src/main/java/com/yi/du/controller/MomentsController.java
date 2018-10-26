package com.yi.du.controller;

import com.alibaba.fastjson.JSON;
import com.yi.du.bean.Appoint;
import com.yi.du.bean.Moments;
import com.yi.du.service.MomentsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Administrator on 2018/4/4.
 */
@RestController
@RequestMapping("/api/Moments")
public class MomentsController extends BaseApiController {

    @Autowired
    MomentsService momentsService;


    @GetMapping("/selectByCondition")
    public Map<String,Object> selectByCondition()
    {
       return onDataResp(momentsService.selectByCondition());
    }

    @GetMapping("/selectPraiseSum")
    public Map<String,Object> selectPraiseSum(@RequestParam(required = false) Integer moments_id)
    {
        return onDataResp(momentsService.selectPraiseSum(moments_id));
    }

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestParam(required = false) Integer user_id, @RequestParam(required = false) String content, @RequestParam(required = false) MultipartFile[] multipartFiles, HttpServletRequest request){
        File tragetFile = null;
        String msg = "";
        ArrayList<String> imagesList = new ArrayList<>();
        if (multipartFiles != null)
        {
            for (MultipartFile file : multipartFiles){
                String fileName = file.getOriginalFilename();
                if (fileName != null && fileName != "") {
                    String returnUrl = request.getContextPath() + "/image/";
                    String path = "E:\\apache-tomcat-9.0.5\\PROJECT\\com.zhouyue\\image";
                    String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;
                    String fileAdd = DateFormatUtils.format(new Date(), "yyyyMMdd");
                    File file1 = new File(path + "/" + fileAdd);
                    if (!file1.exists() && !file1.isDirectory()) {
                        file1.mkdir();
                    }
                    tragetFile = new File(file1, fileName);
                    try {
                        file.transferTo(tragetFile);
                        msg = returnUrl + fileAdd + "/" + fileName;
                        imagesList.add(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String json = JSON.toJSONString(imagesList);
        Moments moments = new Moments();
        moments.setUser_id(user_id);
        moments.setContent(content);
        moments.setCreateDateTime(new Date());
        moments.setImagePath(json);
        momentsService.insert(moments);
        return onSuccessRep("发表成功");
    }

    @PostMapping("/updateById")
    public Map<String,Object> updateById(@RequestParam(required = false) Integer moments_id)
    {
        Moments moments1 = momentsService.selectPraiseSum(moments_id);
        Integer num = moments1.getPraise();
        Integer s = num+1;
        Moments moments = new Moments();
        moments.setMoments_id(moments_id);
        moments.setPraise(s);
        momentsService.updateById(moments);
        return onSuccessRep("点赞+1");
    }
}
