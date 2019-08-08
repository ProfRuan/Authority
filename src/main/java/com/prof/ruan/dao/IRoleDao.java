package com.prof.ruan.dao;

import com.prof.ruan.entity.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IRoleDao {

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(property = "permissions", column = "id" , many = @Many(
                    select = "com.prof.ruan.dao.IPermissionDao.findById"
            )),
            @Result(property = "roleName",column = "role_name")
    })
    public Role findById(Integer id);
}
