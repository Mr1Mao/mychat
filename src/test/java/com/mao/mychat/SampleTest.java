package com.mao.mychat;


import com.mao.mychat.entity.Role;
import com.mao.mychat.entity.User;
import com.mao.mychat.mapper.RoleMapper;
import com.mao.mychat.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper RoleMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- testSelect 方法执行------"));

        User user = userMapper.getUser("mao");
        System.out.println(user.toString());
//        List<Role> userList = RoleMapper.selectList(null);
//        userList.forEach(System.out::println);
//        Role role = RoleMapper.selectById(1);
//            System.out.println(role.toString());

    }

    @Test
    public void testInsert(){
        System.out.println(("----- testInsert 方法执行------"));
//        User user = new User();
//        user.setUsername("毛大帅2132");
//        user.setPassword("1241232qwraa1125");
//
//        int result = userMapper.insert(user);
//
//        System.out.println(result);
//        System.out.println(user);
    }

    @Test
    public void tokenCreateTest(){
        String token = Jwts.builder()
//        主题 放入用户名
                .setSubject("mao1")
//        自定义属性 放入用户拥有请求权限
                .claim("authorities","admin")
//        失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 60 * 1000))
//        签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, "tmax1111AAA")
                .compact();
             log.info("生成的Token为："+token);
    }

    @Test
    public void tokenDecodeTest(){
//        解析token
        Claims claims = Jwts.parser()
                .setSigningKey("tmax")
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW8xIiwiYXV0aG9yaXRpZXMiOiJhZG1pbiIsImV4cCI6MTU5NTgyOTUxNn0.UTiiITA1WSE3xTqr174ZTJeWDsA7sJGZEMmHNZj_AefP2LxVEOd1rdW_l0T0ojDAYHm0-NDS3GaGTlcHPA68Fw")
                .getBody();
        log.info("token解码的：" + claims);
    }


}
