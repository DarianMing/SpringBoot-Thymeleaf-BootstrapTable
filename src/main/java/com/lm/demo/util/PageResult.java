package com.lm.demo.util;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageResult<T> {

    private Long total;

    private List<T> rows;

}
