package com.yi.du.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Post post=new Post();

        Map<String,String> params = new HashMap<String, String>();
        params.put("username","123456");
        params.put("password","123456789");
//        params.put("Br_stop","2011111111");
//        params.put("book_name","Objiective-C");
//        params.put("picUrl","/image/1.jpg");
//        params.put("location","计算机类");
//        params.put("Br_start","2018-4-1");
//        params.put("Br_stop","2018-4-2");
//        params.put("status","0");
////        params.put("sid","2");
//        params.put("mount","10");
//        params.put("location","计算机类");
//        params.put("version","0");

        String response = post.request("http://localhost:8080/api/Student/login", params);
        System.out.print(response);
//
//    }
    }

}
