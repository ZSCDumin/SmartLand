package com.guotu.gt.controller;

import com.guotu.gt.dto.PermissionUserDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionUserDTOService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissionuserdto")
@Api(tags = "用户管理模块")
public class PermissionUserDTOController {
    
    @Autowired
    PermissionUserDTOService permissionUserDTOService;

    @PostMapping
    @ApiOperation(value="增加一个用户管理信息")
    public Result<PermissionUserDTO> add(@RequestBody PermissionUserDTO permissionUserDTO){
        return ResultUtil.success(permissionUserDTOService.add(permissionUserDTO));
    }

    @PutMapping
    @ApiOperation(value = "更新一个用户管理信息")
    public Result<PermissionUserDTO> update(@RequestBody PermissionUserDTO permissionUserDTO){
        permissionUserDTOService.update(permissionUserDTO);
        return ResultUtil.success();
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个用户管理信息")
    public Result<Object> delete(@RequestParam("name") String name){
        permissionUserDTOService.delete(name);
        return ResultUtil.success();
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户管理信息")
    public Result<List<PermissionUserDTO>> findAll(){
        return ResultUtil.success(permissionUserDTOService.findAll());
    }
}
