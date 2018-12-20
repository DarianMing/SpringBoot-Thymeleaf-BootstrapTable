package com.lm.demo;

import com.lm.demo.model.DepartmentEntity;
import com.lm.demo.service.DepartmentService;
import com.lm.demo.util.UUIDUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    DepartmentService departmentService;

    @Test
    public void test () {
        for (int i = 0; i < 9; i++) {
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId(UUIDUtil.getUniqueIdByUUId()).setName("研发部" + i).setParentId(String.valueOf(i + 1))
                    .setManagerId("admin").setRemark("暂无描述").setLevel(String.valueOf(i + 1));
            departmentService.insert(departmentEntity);
        }
    }

    @Test
    public void contextLoads() {
    }

}

