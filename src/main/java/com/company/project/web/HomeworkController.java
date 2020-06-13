package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Homework;
import com.company.project.service.HomeworkService;
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
@RequestMapping("/homework")
public class HomeworkController {
    @Resource
    private HomeworkService homeworkService;

    @PostMapping
    public Result add(@RequestBody Homework homework) {
        homeworkService.save(homework);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        homeworkService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Homework homework) {
        homeworkService.update(homework);
        return ResultGenerator.genSuccessResult();
    }

    /*@GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Homework homework = homeworkService.findById(id);
        return ResultGenerator.genSuccessResult(homework);
    }*/

    @GetMapping("/{name}")
    public Result detail(@PathVariable String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Homework.class);
        example.setOrderByClause("date DESC");
        Example.Criteria c = example.createCriteria();
        c.andLike("name","%"+name+"%");
        List<Homework> list= homeworkService.selectByExample(example);
        for (Homework hw:list) {
            hw.setDate2(sdf.format(hw.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Homework.class);
        example.setOrderByClause("date DESC");
        List<Homework> list = homeworkService.selectByExample(example);
        for (Homework hw:list) {
            hw.setDate2(sdf.format(hw.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
