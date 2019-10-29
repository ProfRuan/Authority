package com.prof.ruan.interceptor;

import com.prof.ruan.config.MyAccessDecisionManager;
import com.prof.ruan.config.MyInvocationSecurityMetadataSource;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: ruan->MyFilterSecurityInterceptor
 * @description: 自定义鉴权过滤器
 * @author: 李宗晋
 * @create: 2019-10-11 11:03
 **/
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    private MyInvocationSecurityMetadataSource securityMetadataSource;

    /**
     * 登陆后，每次访问资源都通过这个拦截器拦截
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        invoke(filterInvocation);
    }

    /**
     * @param filterInvocation 里面有一个被拦截的url
     */
    private void invoke(FilterInvocation filterInvocation) throws IOException, ServletException {
        InterceptorStatusToken statusToken = super.beforeInvocation(filterInvocation);
        try {
            // 执行下一个拦截器
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
        } finally {
            super.afterInvocation(statusToken, null);
        }
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void setAuthenticationManager(AuthenticationManager newManager) {
        super.setAuthenticationManager(newManager);
    }

    public void setSecurityMetadataSource(MyInvocationSecurityMetadataSource myInvocationSecurityMetadataSource){
        this.securityMetadataSource = myInvocationSecurityMetadataSource;
    }

    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager){
        super.setAccessDecisionManager(myAccessDecisionManager);
    }
}
