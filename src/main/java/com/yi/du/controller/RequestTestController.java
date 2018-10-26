package com.yi.du.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/26.
 */
@RestController
@RequestMapping("/api/RequestTest")
public class RequestTestController {

    @GetMapping("/testString")
    public String testString() {
        System.out.println("testString");
        return "返回：this is a test string. Time:2017-10-29 20:42:00";
    }

}
