package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Moment;
import com.company.project.model.Org;
import com.company.project.service.OrgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
* Created by CodeGenerator on 2020/04/19.
*/
@RestController
@RequestMapping("/org")
public class OrgController {
    @Resource
    private OrgService orgService;

    @PostMapping
    public Result add(@RequestBody Org org) {
        orgService.save(org);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orgService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Org org) {
        orgService.update(org);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/o/{id}")
    public Result detail(@PathVariable String id) {
        List<Org> list = orgService.findByIds(id);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/{name}")
    public Result detail(@PathVariable String name,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Example example = new Example(Org.class);
        Example.Criteria c = example.createCriteria();
        c.andLike("name","%"+name+"%");
        List<Org> list = orgService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Org> list = orgService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/asc")
    public Result list2(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Example example = new Example(Org.class);
        example.setOrderByClause("distance ASC");
        List<Org> list = orgService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
