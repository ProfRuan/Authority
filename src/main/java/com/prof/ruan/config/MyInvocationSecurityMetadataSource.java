package com.prof.ruan.config;

import com.prof.ruan.entity.po.Role;
import com.prof.ruan.entity.vo.MenuVo;
import com.prof.ruan.service.MenuService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: ruan->MyInvocationSecurityMetadataSource
 * @description: 资源源数据定义
 * @author: 李宗晋
 * @create: 2019-10-11 11:15
 **/
@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

    @Autowired
    private MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
        String url = ((FilterInvocation)obj).getRequestUrl();

        MenuVo menuVo = menuService.getMenuByUrl(url);
        if(null == menuVo){
            return Collections.EMPTY_LIST;
        }
        Set<Role> roles = menuVo.getRoles();
        //如果路径不存在对应角色，返回一个空的角色集合
        if(null == roles || roles.size() == 0){
            return Collections.EMPTY_LIST;
        }
        //提取角色名称
        String[] roleStrList = new String[roles.size()];
        Iterator<Role> roleIt = roles.iterator();
        Role role;
        int i = 0;
        while(roleIt.hasNext()){
            role = roleIt.next();
            if(1 == role.getValid()){
                roleStrList[i] = ("ROLE_"+role.getRoleName().toUpperCase());
                i++;
            }
        }
        return SecurityConfig.createList(roleStrList);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
