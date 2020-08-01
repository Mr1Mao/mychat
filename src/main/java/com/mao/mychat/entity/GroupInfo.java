package com.mao.mychat.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
/**
 * 讨论组（群）信息 对应实体类
 */
@Data
@NoArgsConstructor
public class GroupInfo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long groupId;
    @NonNull
    private Long owner;
    @NonNull
    private String groupName;
    @NonNull
    private String headImgUrl;
    private String notice;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
