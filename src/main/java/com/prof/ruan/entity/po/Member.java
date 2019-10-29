package com.prof.ruan.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: ruan->Member
 * @description: 用户表
 * @author: 李宗晋
 * @create: 2019-10-29 10:44
 **/
@Data
public class Member {

    private Long id;
    //用户名称
    private String memberName;
    //密码
    private String password;
    //邮箱账号
    private String email;
    //性别
    private short sex;
    //生日
    private Date birthday;
    //创建时间
    private Date createTime;
}
