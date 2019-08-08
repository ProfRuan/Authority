package com.prof.ruan.service;

import com.prof.ruan.dao.IMemberDao;
import com.prof.ruan.entity.Member;
import com.prof.ruan.entity.Permission;
import com.prof.ruan.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 重写Security的UserDetailService
 */
@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private IMemberDao memberDao;

    // 可用性 :true:可用 false:不可用
    boolean enabled = true;
    // 过期性 :true:没过期 false:过期
    boolean accountNonExpired = true;
    // 有效性 :true:凭证有效 false:凭证无效
    boolean credentialsNonExpired = true;
    // 锁定性 :true:未锁定 false:已锁定
    boolean accountNonLocked = true;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Member member = memberDao.findByMemberName(userName);
        if(null == member){
            throw new UsernameNotFoundException(userName);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : member.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorities.add(grantedAuthority);
        }

        User user = new User(member.getMemberName(), member.getPassword() , enabled ,accountNonExpired , credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
