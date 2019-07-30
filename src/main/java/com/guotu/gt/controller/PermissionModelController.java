package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionModel;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionModelService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissionmodel")
@Api(tags = "模块信息")
public class PermissionModelController {
    @Autowired
    private PermissionModelService permissionModelService;

    @PostMapping
    @ApiOperation(value="增加一个模块信息")
    public Result<PermissionModel> add(@RequestBody PermissionModel permissionModel){
        return ResultUtil.success(permissionModelService.add(permissionModel));
    }

    @PutMapping
    @ApiOperation(value = "更新一个模块信息")
    public Result<PermissionModel> update(@RequestBody PermissionModel permissionModel){
        return ResultUtil.success(permissionModelService.update(permissionModel));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个模块信息")
    public Result<Object> delete(@RequestParam("code") int code){
        permissionModelService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询模块信息")
    public Result<PermissionModel> findByCode(@RequestParam("code") int code){
        return ResultUtil.success(permissionModelService.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有模块信息")
    public Result<List<PermissionModel>> findAll(){
        return ResultUtil.success(permissionModelService.findAll());
    }
}
