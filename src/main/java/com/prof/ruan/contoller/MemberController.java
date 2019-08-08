package com.prof.ruan.contoller;

import com.prof.ruan.service.MyUserDetailService;
import com.prof.ruan.util.Result;
import com.prof.ruan.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal principal){
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
