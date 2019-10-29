package com.prof.ruan.contoller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import com.prof.ruan.util.GZipUtil;
import com.prof.ruan.util.NoEncryptPasswordEncoder;
import com.prof.ruan.util.Result;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class TestController {

    @Autowired
    protected HttpServletRequest request;

    public static void main(String[] args){
        String password = "123456";
        BCryptPasswordEncoder noEncryptPasswordEncoder = new BCryptPasswordEncoder();
        password = noEncryptPasswordEncoder.encode(password);
        System.out.println(password);
    }

    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("/test")
    public String test() throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = request.getParameter("checkedName");
        String rootTree = request.getParameter("rootTree");
//        System.out.println("JSON:");
//        System.out.println(JSONArray.parseArray(a).toJSONString());
//
//        String compress = GZipUtil.compress(a);
//        System.out.println("==================================================================");
//        System.out.println("Gzip compress:");
//        System.out.println(compress);
//        System.out.println("==================================================================");
//
//        String unCompress = GZipUtil.uncompress(compress);
//        System.out.println("==================================================================");
//        System.out.println("Gzip uncompress:");
//        System.out.println(unCompress);
//        System.out.println("==================================================================");

        redisTemplate.opsForValue().set(name,JSONArray.parseArray(rootTree).toJSONString());
        return JSONArray.parseArray(rootTree).toJSONString();
    }

    @RequestMapping("/test1")
    public String test1(){
        String a = request.getParameter("checkedName");
        Object obj = redisTemplate.opsForValue().get(a);
        return null == obj?"":obj.toString();
    }
}
