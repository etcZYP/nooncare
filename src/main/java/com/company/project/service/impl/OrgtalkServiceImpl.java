package com.company.project.service.impl;

import com.company.project.dao.OrgtalkMapper;
import com.company.project.model.Orgtalk;
import com.company.project.service.OrgtalkService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/14.
 */
@Service
@Transactional
public class OrgtalkServiceImpl extends AbstractService<Orgtalk> implements OrgtalkService {
    @Resource
    private OrgtalkMapper orgtalkMapper;

}
