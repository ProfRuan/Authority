package com.prof.ruan.dao;


import com.prof.ruan.entity.Member;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMemberDao {

    @Select("select * from member where member_name = #{memberName}")
    @Results({
            @Result(property = "roles", column = "id", many = @Many(
                    select = "com.prof.ruan.dao.IRoleDao.findById"
            )),
            @Result(column = "member_name",property = "memberName")
    })
    public Member findByMemberName(String memberName);
}
