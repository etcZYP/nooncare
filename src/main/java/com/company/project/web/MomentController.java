package com.company.project.web;

import com.company.project.core.RelativeDateFormat;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Moment;
import com.company.project.service.MomentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
* Created by CodeGenerator on 2020/04/21.
*/
@RestController
@RequestMapping("/moment")
public class MomentController {
    @Resource
    private MomentService momentService;

    @PostMapping
    public Result add(@RequestBody Moment moment) {
        momentService.save(moment);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        momentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Moment moment) {
        momentService.update(moment);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Moment moment = momentService.findById(id);
        return ResultGenerator.genSuccessResult(moment);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        Example example = new Example(Moment.class);
        example.setOrderByClause("time DESC");
        List<Moment> list = momentService.selectByExample(example);
        for (Moment m:list) {
            m.setTime2(RelativeDateFormat.format(m.getTime()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
