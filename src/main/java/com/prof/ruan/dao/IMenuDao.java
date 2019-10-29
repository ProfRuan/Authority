package com.prof.ruan.dao;

import com.prof.ruan.entity.vo.MenuVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @program: ruan->IMenuDao
 * @description: 菜单持久层
 * @author: 李宗晋
 * @create: 2019-10-29 11:34
 **/
public interface IMenuDao {

    @Select("select * from menu where url = #{url}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "pId",column = "p_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "type",column = "type"),
            @Result(property = "vaild",column = "vaild"),
            @Result(property = "createDate",column = "createDate"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",javaType = java.util.Set.class,column = "id",
            many = @Many(select = "com.prof.ruan.dao.IMenuRoleDao.findRoleByMenuId"))
    })
    public MenuVo findMenuByUrl(String url);
}
