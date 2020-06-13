package com.company.project.service.impl;

import com.company.project.dao.HomeworkMapper;
import com.company.project.model.Homework;
import com.company.project.service.HomeworkService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/14.
 */
@Service
@Transactional
public class HomeworkServiceImpl extends AbstractService<Homework> implements HomeworkService {
    @Resource
    private HomeworkMapper homeworkMapper;

}
