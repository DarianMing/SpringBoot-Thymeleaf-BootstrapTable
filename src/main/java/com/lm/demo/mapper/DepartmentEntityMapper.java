package com.lm.demo.mapper;

import com.lm.demo.model.DepartmentEntity;

import java.util.List;

public interface DepartmentEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(DepartmentEntity record);

    int insertSelective(DepartmentEntity record);

    DepartmentEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DepartmentEntity record);

    int updateByPrimaryKey(DepartmentEntity record);

    List<DepartmentEntity> selectDepartments (DepartmentEntity departmentEntity);
}