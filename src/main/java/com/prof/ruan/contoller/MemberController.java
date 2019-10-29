package com.prof.ruan.contoller;

import com.prof.ruan.util.Result;
import com.prof.ruan.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class MemberController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal principal){
        System.out.println("token:"+request.getParameter("access_token"));
        return principal;
    }

    @DeleteMapping("/exit")
    public Result revokeToken(String accessToken){
        Result rlt = new Result();
        if(consumerTokenServices.revokeToken(accessToken)){
            rlt.setCode(ResultCode.SUCCESS.getCode());
            rlt.setMessage("注销成功");
        }else{
            rlt.setCode(ResultCode.FAILED.getCode());
            rlt.setMessage("注销失败");
        }
        return rlt;
    }
}
