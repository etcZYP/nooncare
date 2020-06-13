package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Org;
import com.company.project.model.Orgtalk;
import com.company.project.service.OrgtalkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by CodeGenerator on 2020/04/27.
 */
@RestController
@RequestMapping("/orgtalk")
public class OrgtalkController {
    @Resource
    private OrgtalkService orgtalkService;

    @PostMapping
    public Result add(@RequestBody Orgtalk orgtalk) {
        orgtalkService.save(orgtalk);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orgtalkService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Orgtalk orgtalk) {
        orgtalkService.update(orgtalk);
        return ResultGenerator.genSuccessResult();
    }

    /*@GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Orgtalk orgtalk = orgtalkService.findById(id);
        return ResultGenerator.genSuccessResult(orgtalk);
    }*/

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Example example = new Example(Orgtalk.class);
        example.setOrderByClause("date DESC");
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("oid",Integer.valueOf(id));
        List<Orgtalk> list = orgtalkService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/my/{name}")
    public Result my(@PathVariable String name,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        Example example = new Example(Orgtalk.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("name",name);
        List<Orgtalk> list = orgtalkService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/cnt/{id}")
    public int count(@PathVariable String id) {
        Orgtalk orgtalk = new Orgtalk();
        orgtalk.setOid(Integer.valueOf(id));
        int num = orgtalkService.selectCount(orgtalk);
        return num;
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Example example = new Example(Orgtalk.class);
        example.setOrderByClause("date DESC");
        List<Orgtalk> list = orgtalkService.selectByExample(example);
        for(Orgtalk o:list){
            o.setDate2(sdf.format(o.getDate()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
