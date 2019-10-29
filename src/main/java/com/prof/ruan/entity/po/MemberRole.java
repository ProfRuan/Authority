package com.prof.ruan.entity.po;

import lombok.Data;

/**
 * @program: ruan->MemberRole
 * @description: 用户角色关联表
 * @author: 李宗晋
 * @create: 2019-10-29 10:44
 **/
@Data
public class MemberRole {

    private Integer id;
    //用户ID
    private Integer memberId;
    //角色ID
    private Integer roleId;
}
