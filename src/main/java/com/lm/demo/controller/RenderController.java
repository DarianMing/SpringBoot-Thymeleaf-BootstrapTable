package com.lm.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.demo.dto.ResponseVo;
import com.lm.demo.model.DepartmentEntity;
import com.lm.demo.service.DepartmentService;
import com.lm.demo.util.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        PageHelper.startPage(offset == 0 ? 1 : offset/limit +1, limit);
        List<DepartmentEntity> departmentEntityList = departmentService.selectDepartments(departmentEntity);
        PageInfo<DepartmentEntity> pages = new PageInfo<>(departmentEntityList);
        return new PageResult<DepartmentEntity>().setRows(departmentEntityList).setTotal(pages.getTotal());
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo edit (DepartmentEntity departmentEntity) {
        int editFlag = departmentService.updateByPrimaryKeySelective(departmentEntity);
        ResponseVo response = new ResponseVo();
        return editFlag > 0 ? response.setCode(200).setMsg("编辑成功") : response.setCode(500).setMsg("编辑失败");
    }

    @GetMapping("/table")
    public String table (DepartmentEntity departmentEntity) {
        return "table";
    }

    @GetMapping("/tableFilter")
    public String tableFilter () {
        return "tableFilter";
    }

//    @PostMapping("/getSubData")
//    @ResponseBody
//    public PageResult getTableData( DepartmentEntity departmentEntity) {
//        List<DepartmentEntity> departmentEntityList = departmentService.selectDepartments(departmentEntity);
//        return new PageResult<DepartmentEntity>().setRows(departmentEntityList).setTotal((long)departmentEntityList.size());
//    }
}
