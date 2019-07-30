package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionOperation;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionOperationService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissionoperation")
@Api(tags = "操作信息")
public class PermissionOperationController {
    
    @Autowired
    PermissionOperationService permissionOperationService;

    @PostMapping
    @ApiOperation(value="增加一个操作信息")
    public Result<PermissionOperation> add(@RequestBody PermissionOperation permissionOperation){
        return ResultUtil.success(permissionOperationService.add(permissionOperation));
    }

    @PutMapping
    @ApiOperation(value = "更新一个操作信息")
    public Result<PermissionOperation> update(@RequestBody PermissionOperation permissionOperation){
        return ResultUtil.success(permissionOperationService.update(permissionOperation));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个操作信息")
    public Result<Object> delete(@RequestParam("code") int code){
        permissionOperationService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询操作信息")
    public Result<PermissionOperation> findByCode(@RequestParam("code") int code){
        return ResultUtil.success(permissionOperationService.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有操作信息")
    public Result<List<PermissionOperation>> findAll(){
        return ResultUtil.success(permissionOperationService.findAll());
    }
}
