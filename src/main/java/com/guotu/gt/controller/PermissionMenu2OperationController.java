package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionMenu2Operation;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionMenu2OperationService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permissionmenu2operation")
@Api(tags = "菜单操作分配信息")
public class PermissionMenu2OperationController {
    
    @Autowired
    PermissionMenu2OperationService permissionMenu2OperationService;

    @PostMapping
    @ApiOperation(value="增加一个菜单操作分配信息")
    public Result<PermissionMenu2Operation> add(@RequestBody PermissionMenu2Operation permissionMenu2Operation){
        return ResultUtil.success(permissionMenu2OperationService.add(permissionMenu2Operation));
    }

    @PutMapping
    @ApiOperation(value = "更新一个菜单操作分配信息")
    public Result<PermissionMenu2Operation> update(@RequestBody PermissionMenu2Operation permissionMenu2Operation){
        return ResultUtil.success(permissionMenu2OperationService.update(permissionMenu2Operation));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个菜单操作分配信息")
    public Result<Object> delete(@RequestParam("code") Byte code){
        permissionMenu2OperationService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询菜单操作分配信息")
    public Result<PermissionMenu2Operation> findByCode(@RequestParam("code") Byte code){
        return ResultUtil.success(permissionMenu2OperationService.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有菜单操作分配信息")
    public Result<List<PermissionMenu2Operation>> findAll(){
        return ResultUtil.success(permissionMenu2OperationService.findAll());
    }
}
