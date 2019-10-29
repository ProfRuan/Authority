package com.prof.ruan.entity.po;

import lombok.Data;

import java.util.Date;
/**
 * @program: ruan->Role
 * @description: 角色表
 * @author: 李宗晋
 * @create: 2019-10-29 10:44
 **/
@Data
public class Role {

    private Integer id;
    //角色名称
    private String roleName;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //是否有效 1是 0否
    private Short valid;
}
