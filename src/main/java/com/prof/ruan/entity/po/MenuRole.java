package com.prof.ruan.entity.po;

import lombok.Data;

/**
 * @program: ruan->MenuRole
 * @description: 菜单角色关系表
 * @author: 李宗晋
 * @create: 2019-10-29 11:31
 **/
@Data
public class MenuRole {

    private Integer id;
    private Integer menuId;
    private Integer roleId;

}
