package com.prof.ruan.dao;

import com.prof.ruan.entity.Permission;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IPermissionDao {

    @Select("select * from permission where id = #{id}")
    @Results({
            @Result(column = "zuul_prefix", property = "zuulPrefix"),
            @Result(column = "service_prefix", property = "servicePrefix")
    })
    public Permission findById(Integer id);
}
