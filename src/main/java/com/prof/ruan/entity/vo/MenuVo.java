package com.prof.ruan.entity.vo;

import com.prof.ruan.entity.po.Menu;
import com.prof.ruan.entity.po.Role;
import lombok.Data;

import java.util.Set;


/**
 * @program: ruan->MenuVo
 * @description: 菜单VO
 * @author: 李宗晋
 * @create: 2019-10-29 11:33
 **/
@Data
public class MenuVo extends Menu {

    private Set<Role> roles;
}
