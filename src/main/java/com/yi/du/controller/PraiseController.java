package com.yi.du.controller;

import com.yi.du.bean.Moments;
import com.yi.du.bean.Praise;
import com.yi.du.service.MomentsService;
import com.yi.du.service.PraiseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/Praise")
public class PraiseController extends BaseApiController{

    @Autowired
    PraiseService praiseService;

    @Autowired
    MomentsService momentsService;

    @GetMapping("/selectPraiseSum")
    public Map<String,Object> selectPraiseSum(@RequestParam(required = false) Integer moments_id)
    {
        return onDataResp(praiseService.selectPraiseSum(moments_id));
    }

    @GetMapping("/selectById")
    public Map<String, Object> selectById(@RequestParam(required = false) Integer user_id, @RequestParam(required = false) Integer moments_id)
    {
        return onDataResp(praiseService.selectById(user_id,moments_id));
    }

    @GetMapping("/selectById1")
    public Map<String, Object> selectById1(@RequestParam(required = false) Integer moments_id)
    {
        return onDataResp(praiseService.selectById1(moments_id));
    }

    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestParam(required = false) Integer user_id, @RequestParam(required = false) Integer moments_id)
    {
        Praise praise1 = praiseService.selectById(user_id,moments_id);
        if (praise1 == null) {
            Moments moments1 = momentsService.selectPraiseSum(moments_id);
            Integer num = moments1.getPraise();
            Integer s = num+1;
            Moments moments = new Moments();
            moments.setMoments_id(moments_id);
            moments.setPraise(s);
            Praise praise = new Praise();
            praise.setUser_id(user_id);
            praise.setMoments_id(moments_id);
            momentsService.updateById(moments);
            praiseService.insert(praise);
            return onSuccessRep("点赞成功");
        }else {
            Moments moments1 = momentsService.selectPraiseSum(moments_id);
            Integer num = moments1.getPraise();
            Integer s = num-1;
            Moments moments = new Moments();
            moments.setMoments_id(moments_id);
            moments.setPraise(s);
            momentsService.updateById(moments);
            praiseService.deleteById(user_id,moments_id);
            return onSuccessRep("点赞取消");
        }
    }

    @PostMapping("/deleteById")
    public Map<String,Object> deleteById(@RequestParam(required = false) Integer user_id, @RequestParam(required = false) Integer moments_id)
    {
        praiseService.deleteById(user_id,moments_id);
        return onSuccessRep("点赞取消");
    }
}
