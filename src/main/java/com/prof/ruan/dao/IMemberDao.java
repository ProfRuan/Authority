package com.prof.ruan.dao;


import com.prof.ruan.entity.vo.MemberVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface IMemberDao {

    @Select("select * from member where member_name = #{memberName}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "memberName",column = "member_name"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "createTime",column = "createTime"),
            @Result(property = "roles",javaType = java.util.Set.class,column = "id",
            many = @Many(select = "com.prof.ruan.dao.IMemberRoleDao.findRoleByMemberId"))
    })
    public MemberVo findByMemberName(String memberName);
}
