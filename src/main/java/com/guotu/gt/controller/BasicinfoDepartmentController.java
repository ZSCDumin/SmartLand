package com.guotu.gt.controller;


import com.guotu.gt.domain.BasicinfoDepartment;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoDepartmentService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/basicinfodepartment")
@Api(tags = "机构信息")
public class BasicinfoDepartmentController {
    @Autowired
    private BasicinfoDepartmentService basicinfoDepartmentService;

    @PostMapping
    @ApiOperation(value="增加一个机构信息")
    public Result<BasicinfoDepartment> add(@RequestBody BasicinfoDepartment basicinfoDepartment){
        return ResultUtil.success(basicinfoDepartmentService.add(basicinfoDepartment));
    }

    @PutMapping
    @ApiOperation(value = "更新一个机构信息")
    public Result<BasicinfoDepartment> update(@RequestBody BasicinfoDepartment basicinfoDepartment){
        return ResultUtil.success(basicinfoDepartmentService.update(basicinfoDepartment));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个机构信息")
    public Result<Object> delete(@RequestParam("code")@ApiParam(value = "机构编码") int code){
        basicinfoDepartmentService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询机构信息")
    public Result<BasicinfoDepartment> findByCode(@RequestParam("code")@ApiParam(value = "机构编码") int code){
        return ResultUtil.success(basicinfoDepartmentService.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有机构信息")
    public Result<List<BasicinfoDepartment>> findAll(){
        return ResultUtil.success(basicinfoDepartmentService.findAll());
    }
}
