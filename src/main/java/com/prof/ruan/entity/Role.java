package com.prof.ruan.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Role {

    private Integer id;
    private String roleName;
    private short valid;
    private Date createTime;
    private Date updateTime;
    private Set<Permission> permissions;
}
