package com.lm.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseVo {

    private Integer code;

    private String msg;
}
