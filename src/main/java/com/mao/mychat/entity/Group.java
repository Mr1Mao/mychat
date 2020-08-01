package com.mao.mychat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 讨论组（群）列表 对应实体类
 */
@Data
@NoArgsConstructor
public class Group {
    @TableId
    private Long idMy;
    private Long groupId;
}
