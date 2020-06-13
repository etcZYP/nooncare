package com.company.project.service.impl;

import com.company.project.dao.MomentMapper;
import com.company.project.model.Moment;
import com.company.project.service.MomentService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/04/24.
 */
@Service
@Transactional
public class MomentServiceImpl extends AbstractService<Moment> implements MomentService {
    @Resource
    private MomentMapper momentMapper;

}
