package com.mao.mychat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 好友列表 对应实体类
 */
@Data
@NoArgsConstructor
public class Friend {
    @TableId
    private Long idMy;
    private Long idFriend;
}
