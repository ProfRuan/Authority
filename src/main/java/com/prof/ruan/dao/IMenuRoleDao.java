package com.prof.ruan.dao;

import com.prof.ruan.entity.po.Role;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @program: ruan->IMenuRoleDao
 * @description: 菜单角色关系持久层
 * @author: 李宗晋
 * @create: 2019-10-29 11:34
 **/
public interface IMenuRoleDao {

    @Select("select r.* from menu_role mr,menu m,role r where mr.menu_id = m.id and mr.role_id = r.id and m.id = #{menuId}")
    public Set<Role> findRoleByMenuId(Integer menuId);
}
