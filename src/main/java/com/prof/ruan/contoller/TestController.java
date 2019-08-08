package com.prof.ruan.contoller;

import com.alibaba.fastjson.JSONObject;
import com.prof.ruan.util.GZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class TestController {

    @Autowired
    protected HttpServletRequest request;

    @RequestMapping("/test")
    public JSONObject test() throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String a = request.getParameter("a").toString();
        JSONObject jsonObject = new JSONObject();
//
//        String compress = GZipUtil.compress(a);
//        System.out.println(compress);
//
//        String unCompress = GZipUtil.uncompress(compress);
//        System.out.println(unCompress);
        return jsonObject;
    }
}
