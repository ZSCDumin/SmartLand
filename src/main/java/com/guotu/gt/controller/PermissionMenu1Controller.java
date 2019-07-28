package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionMenu1;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionMenu1Service;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissionmenu1")
@Api(tags = "一级菜单信息")
public class PermissionMenu1Controller {

    @Autowired
    private PermissionMenu1Service permissionMenu1Service;

    @PostMapping
    @ApiOperation(value="增加一个一级菜单信息")
    public Result<PermissionMenu1> add(@RequestBody PermissionMenu1 permissionMenu1){
        return ResultUtil.success(permissionMenu1Service.add(permissionMenu1));
    }

    @PutMapping
    @ApiOperation(value = "更新一个一级菜单信息")
    public Result<PermissionMenu1> update(@RequestBody PermissionMenu1 permissionMenu1){
        return ResultUtil.success(permissionMenu1Service.update(permissionMenu1));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个一级菜单信息")
    public Result<Object> delete(@RequestParam("code") Byte code){
        permissionMenu1Service.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询一级菜单信息")
    public Result<PermissionMenu1> findByCode(@RequestParam("code") Byte code){
        return ResultUtil.success(permissionMenu1Service.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有一级菜单信息")
    public Result<List<PermissionMenu1>> findAll(){
        return ResultUtil.success(permissionMenu1Service.findAll());
    }
}
