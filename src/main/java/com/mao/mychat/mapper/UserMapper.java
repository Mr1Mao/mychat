package com.mao.mychat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mao.mychat.entity.Role;
import com.mao.mychat.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

    @Results(id="userMap",value = {
            @Result(property = "userId", column = "user_id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "eMail", column = "e-mail"),
            @Result(property = "headImgUrl", column = "head_img_url"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "roleId", column = "role_id"),
            @Result(property="roles",column="role_id"
                    ,many =@Many(select="com.mao.mychat.mapper.RoleMapper.selectById"))
    })
    @Select("SELECT *  FROM  `user`  WHERE username = #{username} ")
    User getUser(String username);

}
