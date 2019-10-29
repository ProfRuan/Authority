package com.prof.ruan.dao;

import com.prof.ruan.entity.po.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @program: ruan->IMemberRoleDao
 * @description: 用户角色关系数据持久层
 * @author: 李宗晋
 * @create: 2019-10-29 11:20
 **/
public interface IMemberRoleDao {

    @Select("select r.* from member_role mr,member m,role r where mr.member_id = m.id and mr.role_id = r.id and m.id = #{memberId}")
    @Results(
            @Result(property = "roleName",column = "role_name")
    )
    public Set<Role> findRoleByMemberId(Integer memberId);
}
