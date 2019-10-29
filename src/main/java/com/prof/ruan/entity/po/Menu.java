package com.prof.ruan.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: ruan->Menu
 * @description: 菜单表
 * @author: 李宗晋
 * @create: 2019-10-29 11:15
 **/
@Data
public class Menu {

    private Integer id;
    //上级菜单
    private Integer pId;
    //菜单名称
    private String name;
    //菜单类型 1:菜单 2:路径
    private Integer type;
    //是否有效 1是 0否
    private Integer vaild;
    private Date createDate;
    //路径
    private String url;
}
