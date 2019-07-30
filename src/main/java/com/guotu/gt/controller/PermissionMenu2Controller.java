package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionMenu2;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionMenu2Service;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissionmenu2")
@Api(tags = "二级菜单信息")
public class PermissionMenu2Controller {

    @Autowired
    private PermissionMenu2Service permissionMenu2Service;

    @PostMapping
    @ApiOperation(value="增加一个二级菜单信息")
    public Result<PermissionMenu2> add(@RequestBody PermissionMenu2 permissionMenu2){
        return ResultUtil.success(permissionMenu2Service.add(permissionMenu2));
    }

    @PutMapping
    @ApiOperation(value = "更新一个二级菜单信息")
    public Result<PermissionMenu2> update(@RequestBody PermissionMenu2 permissionMenu2){
        return ResultUtil.success(permissionMenu2Service.update(permissionMenu2));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个二级菜单信息")
    public Result<Object> delete(@RequestParam("code") int code){
        permissionMenu2Service.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询二级菜单信息")
    public Result<PermissionMenu2> findByCode(@RequestParam("code") int code){
        return ResultUtil.success(permissionMenu2Service.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有二级菜单信息")
    public Result<List<PermissionMenu2>> findAll(){
        return ResultUtil.success(permissionMenu2Service.findAll());
    }
}
