package com.mao.mychat.controller;

import com.mao.mychat.entity.User;
import com.mao.mychat.service.RegisterService;
import com.mao.mychat.utils.ResponeFormat;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登入注册Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private RegisterService registerService;

    /**
     * 测试
     * @return
     */
    @PostMapping("/hello")
    public ResponeFormat hello(){
//        log.info(user.toString());
        return new ResponeFormat("200","测试","数据");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PutMapping("/register")
    public ResponeFormat register(@RequestBody User user){
        int result = registerService.addUser(user);
        if (result == 1){
            return new ResponeFormat("200","测试",user);
        }else if (result == 2){
            return new ResponeFormat("200","测试","数据有误");
        }else{
            return new ResponeFormat("200","测试","预料之外的问题");
        }

    }
}
