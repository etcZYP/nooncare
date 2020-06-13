package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Eat;
import com.company.project.service.EatService;
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
@RequestMapping("/eat")
public class EatController {
    @Resource
    private EatService eatService;

    @PostMapping
    public Result add(@RequestBody Eat eat) {
        eatService.save(eat);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        eatService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Eat eat) {
        eatService.update(eat);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Eat eat = eatService.findById(id);
        return ResultGenerator.genSuccessResult(eat);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Eat.class);
        example.setOrderByClause("date DESC");
        List<Eat> list = eatService.selectByExample(example);
        for (Eat e:list) {
            e.setDate2(sdf.format(e.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
