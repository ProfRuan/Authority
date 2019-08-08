package com.prof.ruan.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    private Integer id;
    private String zuulPrefix;
    private String servicePrefix;
    private String method;
    private String uri;
    private Date createTime;
    private Date updateTime;
}
