package com.prof.ruan.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Member {


    private Long id;
    private String memberName;
    private String password;
    private String email;
    private short sex;
    private Date birthday;
    private Date createTime;
    private Set<Role> roles;
}
