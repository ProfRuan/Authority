package com.prof.ruan.service;

import com.prof.ruan.dao.IMenuDao;
import com.prof.ruan.entity.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: ruan->MenuService
 * @description: 角色业务逻辑层
 * @author: 李宗晋
 * @create: 2019-10-29 11:44
 **/
@Service("menuService")
public class MenuService {

    @Resource
    private IMenuDao menuDao;

    public MenuVo getMenuByUrl(String url){
        return menuDao.findMenuByUrl(url);
    }
}
