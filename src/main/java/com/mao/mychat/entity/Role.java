package com.mao.mychat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
/**
 * 用户角色（权限） 对应实体类
 */
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @TableId
    private Long roleId;
    private String roleName;
    private String roleDescription;

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
