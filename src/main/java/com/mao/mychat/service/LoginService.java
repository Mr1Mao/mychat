package com.mao.mychat.service;

import com.mao.mychat.entity.User;
import com.mao.mychat.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户登入服务层
 */
@Slf4j
@Service
public class LoginService implements UserDetailsService  {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println(s);
        User user = userMapper.getUser(s);
        log.info("登入的用户为："+ user.toString());
        if (user == null) {
            log.info("用户名不存在");
        }
        return user;
    }

}
