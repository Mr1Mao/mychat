package com.mao.mychat.config;

import com.mao.mychat.config.filter.JWTAuthenticationFilter;
import com.mao.mychat.headler.UserLogoutSuccessHandler;
import com.mao.mychat.service.LoginService;
import com.mao.mychat.headler.UserLoginAuthenticationFailureHandler;
import com.mao.mychat.headler.UserLoginAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 注入 密码加密
     */
    @Autowired
    private LoginService loginService;
    /**
     * 注入 用户登入成功处理类
     */
    @Autowired
    private UserLoginAuthenticationSuccessHandler userLoginAuthenticationSuccessHandler;
    /**
     * 注入 用户登录失败处理类
     */
    @Autowired
    private UserLoginAuthenticationFailureHandler userLoginAuthenticationFailureHandler;
    /**
     * 注入 用户注册成功处理类
     */
    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

    /**
     * 密码加密处理
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    };

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .successHandler(userLoginAuthenticationSuccessHandler)
                .failureHandler(userLoginAuthenticationFailureHandler)

                .and()
                .authorizeRequests()
                .antMatchers("/register")
                .permitAll()
                .anyRequest()
                .authenticated()

//                .and()
//                使用jwt所以无需 logout()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(userLogoutSuccessHandler)
//                .deleteCookies("JSESSIONID")

                .and()
                .csrf().disable()
        //        前后端分离采用JWT 关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
    //          添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));

        // 禁用缓存
        http.headers().cacheControl();
    }
    /**
     * 开放的静态资源
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico");

    }
}
