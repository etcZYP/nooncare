package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Baby;
import com.company.project.service.BabyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/01.
*/
@RestController
@RequestMapping("/baby")
public class BabyController {
    @Resource
    private BabyService babyService;

    @PostMapping
    public Result add(@RequestBody(required = false) Baby baby) {
        babyService.save(baby);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        babyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Baby baby) {
        babyService.update(baby);
        return ResultGenerator.genSuccessResult();
    }

    /*@GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Baby baby = babyService.findById(id);
        return ResultGenerator.genSuccessResult(baby);
    }*/

    @GetMapping("/{name}")
    public Result detail(@PathVariable String name) {
        Example example = new Example(Baby.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("pname",name);
        List<Baby> list = babyService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Baby> list = babyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
