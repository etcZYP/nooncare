package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Signin;
import com.company.project.service.SigninService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/14.
*/
@RestController
@RequestMapping("/signin")
public class SigninController {
    @Resource
    private SigninService signinService;

    @PostMapping
    public Result add(@RequestBody Signin signin) {
        signinService.save(signin);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        signinService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Signin signin) {
        signinService.update(signin);
        return ResultGenerator.genSuccessResult();
    }

    /*@GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Signin signin = signinService.findById(id);
        return ResultGenerator.genSuccessResult(signin);
    }*/

    @GetMapping("/{name}")
    public Result detail(@PathVariable String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Signin.class);
        Example.Criteria c = example.createCriteria();
        c.andLike("name","%"+name+"%");
        List<Signin> list = signinService.selectByExample(example);
        for (Signin s:list) {
            s.setDate2(sdf.format(s.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Signin.class);
        example.setOrderByClause("date DESC");
        List<Signin> list = signinService.selectByExample(example);
        for (Signin s:list) {
            s.setDate2(sdf.format(s.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
