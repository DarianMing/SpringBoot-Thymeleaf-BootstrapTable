package com.lm.demo.service;

import com.lm.demo.model.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    int insert(DepartmentEntity record);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    List<DepartmentEntity> selectDepartments (DepartmentEntity departmentEntity);
}
