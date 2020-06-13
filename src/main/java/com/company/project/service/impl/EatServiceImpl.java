package com.company.project.service.impl;

import com.company.project.dao.EatMapper;
import com.company.project.model.Eat;
import com.company.project.service.EatService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/14.
 */
@Service
@Transactional
public class EatServiceImpl extends AbstractService<Eat> implements EatService {
    @Resource
    private EatMapper eatMapper;

}
