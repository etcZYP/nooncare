package com.company.project.service.impl;

import com.company.project.dao.SigninMapper;
import com.company.project.model.Signin;
import com.company.project.service.SigninService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/14.
 */
@Service
@Transactional
public class SigninServiceImpl extends AbstractService<Signin> implements SigninService {
    @Resource
    private SigninMapper signinMapper;

}
