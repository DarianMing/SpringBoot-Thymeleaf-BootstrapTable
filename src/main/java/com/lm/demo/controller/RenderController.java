package com.lm.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.demo.model.DepartmentEntity;
import com.lm.demo.service.DepartmentService;
import com.lm.demo.util.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("render")
public class RenderController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/getData")
    @ResponseBody
    public PageResult getTableData( DepartmentEntity departmentEntity , Integer limit, Integer offset) {
        PageHelper.startPage(offset, limit);
        List<DepartmentEntity> departmentEntityList = departmentService.selectDepartments(departmentEntity);
        PageInfo<DepartmentEntity> pages = new PageInfo<>(departmentEntityList);

//        List<Department> list = new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            Department department = Department.builder()
//                    .id(UUIDUtil.getUniqueIdByUUId())
//                    .name("研发部" + i)
//                    .level(String.valueOf(i))
//                    .desc("暂无描述")
//                    .build();
//            list.add(department);
//        }
        return new PageResult<DepartmentEntity>().setRows(departmentEntityList).setTotal(pages.getTotal());
    }
}
