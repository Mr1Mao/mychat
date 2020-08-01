package com.mao.mychat.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *  放回前端的格式
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponeFormat {
    private String code;
    private String message;
    private Object data;
}
