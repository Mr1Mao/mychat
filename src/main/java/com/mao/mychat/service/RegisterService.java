package com.mao.mychat.service;

import com.mao.mychat.entity.Role;
import com.mao.mychat.entity.User;
import com.mao.mychat.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户注册服务层
 */
@Slf4j
@Service
public class RegisterService {
    /**
     * 密码加密
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册方法
     * @param user
     * @return 0,1,2  插入失败，注册成功，username 或 password 等于空
     */
    public int addUser(User user){
        if(user.getUsername() != null && user.getPassword() !=null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            List<Role> roleList = new ArrayList<Role>();
//            roleList.add(new Role(1L));
            user.setRoleId(1L);
            int result = userMapper.insert(user);
            log.info("result", result);
            if (result == 1){
                return 1;
            }else{
                return 0;
            }
        }else {
            return 2;
        }
    }
}
