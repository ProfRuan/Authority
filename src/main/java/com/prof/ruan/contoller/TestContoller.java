package com.prof.ruan.contoller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContoller {

    @RequestMapping("/")
    public JSONObject test(){
        JSONObject j = new JSONObject();
        j.put("answer","AI");
        return j;
    }
}
