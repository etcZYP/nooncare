package com.conpany.project;

import com.company.project.service.MomentService;
import org.junit.Test;

import javax.annotation.Resource;

public class MyTest extends Tester {
    @Resource
    private MomentService momentService;
    @Test
    public void testDeleteMomentById(){
        momentService.deleteById(1);
    }
}
