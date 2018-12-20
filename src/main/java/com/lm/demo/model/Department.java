package com.lm.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Department {
    private String id;
    private String name;
    private String level;
    private String desc;
}
