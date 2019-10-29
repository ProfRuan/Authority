package com.prof.ruan.config;

import com.netflix.discovery.converters.Auto;
import com.prof.ruan.interceptor.MyFilterSecurityInterceptor;
import com.prof.ruan.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class OAuthConfig {

    private static final String RESOURCE_ID = "web";

    /**
     * 配置资源管理器
     */
    @Configuration
    @EnableResourceServer
    @Order(3)
    protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter{

        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources.resourceId(RESOURCE_ID).stateless(true);
        }
        @Autowired
        MyAccessDecisionManager myAccessDecisionManager;
        @Autowired
        MyInvocationSecurityMetadataSource myInvocationSecurityMetadataSource;
        @Autowired
        AuthenticationManager authenticationManager;


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated();
            http.addFilterAfter(createApiAuthenticationFilter(), FilterSecurityInterceptor.class);
        }

        private MyFilterSecurityInterceptor createApiAuthenticationFilter() {
            MyFilterSecurityInterceptor interceptor = new MyFilterSecurityInterceptor();
            interceptor.setAuthenticationManager(authenticationManager);
            interceptor.setSecurityMetadataSource(myInvocationSecurityMetadataSource);
            interceptor.setMyAccessDecisionManager(myAccessDecisionManager);
            return interceptor;
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;
        @Autowired
        MyUserDetailService myUserDetailService;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            clients.inMemory().withClient("web")
                    .resourceIds(RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("web")
                    .authorities("web")
                    .secret("web");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .userDetailsService(myUserDetailService)//refresh_token需要配置
                    .tokenStore(new RedisTokenStore(redisConnectionFactory))//token存储位置
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST)//请求方式
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            //允许表单认证
            oauthServer.allowFormAuthenticationForClients();
            oauthServer.tokenKeyAccess("permitAll()");
            oauthServer.checkTokenAccess("isAuthenticated()");
        }

    }
}
