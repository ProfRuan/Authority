package com.prof.ruan.entity.vo;

import com.prof.ruan.entity.po.Member;
import com.prof.ruan.entity.po.Role;
import lombok.Data;

import java.util.Set;

/**
 * @program: ruan->MemberVo
 * @description: 用户VO
 * @author: 李宗晋
 * @create: 2019-10-29 10:59
 **/
@Data
public class MemberVo extends Member {

    private Set<Role> roles;
}
