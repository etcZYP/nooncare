package com.company.project.service.impl;

import com.company.project.dao.BabyMapper;
import com.company.project.model.Baby;
import com.company.project.service.BabyService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/01.
 */
@Service
@Transactional
public class BabyServiceImpl extends AbstractService<Baby> implements BabyService {
    @Resource
    private BabyMapper babyMapper;

}
