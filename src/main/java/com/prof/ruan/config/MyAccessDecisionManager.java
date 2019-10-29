package com.prof.ruan.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @program: ruan->MyAccessDecisionManager
 * @description: 访问决策器，决定某个用户具有的角色，是否有足够的权限去访问某个资源
 * @author: 李宗晋
 * @create: 2019-10-11 14:33
 **/
@Component("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        // 判断用户所拥有的权限，是否符合对应的Url权限，用户权限是实现 UserDetailsService#loadUserByUsername 返回用户所对应的权限
        Iterator<ConfigAttribute> ite = collection.iterator();
        while (ite.hasNext()) {
            ConfigAttribute neededAuthority = ite.next();
            String neededAuthorityStr = neededAuthority.getAttribute();
            for (GrantedAuthority existingAuthority : authentication.getAuthorities()) {
                if (neededAuthorityStr.equals(existingAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
