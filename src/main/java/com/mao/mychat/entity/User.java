package com.mao.mychat.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
/**
 * 用户信息 对应实体类
 */
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String phoneNumber;
    private String eMail;
    @NonNull
    private String headImgUrl;

    @TableField(value = "role_id")
    private Long  roleId;

    @NonNull
    @TableField(exist= false)
    private List<Role> roles;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
