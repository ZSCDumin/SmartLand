package com.guotu.gt.controller;

import com.guotu.gt.dto.PermissionUserDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionUserDTOService;
import com.guotu.gt.service.PermissionUserRoleService;
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

    @Autowired
    PermissionUserRoleService permissionUserRoleService;

    @PutMapping
    @ApiOperation(value="增加一个用户管理信息")
    public Result<PermissionUserDTO> add(@RequestBody PermissionUserDTO permissionUserDTO){
        permissionUserDTOService.add(permissionUserDTO);
        permissionUserRoleService.insertCodeName(permissionUserDTO.getCode(),permissionUserDTO.getRoleName());
        return ResultUtil.success(permissionUserDTOService.findByName(permissionUserDTO.getName()));
    }

    @PostMapping
    @ApiOperation(value = "更新一个用户管理信息")
    public Result<PermissionUserDTO> update(@RequestBody PermissionUserDTO permissionUserDTO){
        permissionUserDTOService.update(permissionUserDTO);
        permissionUserRoleService.updateCodeName(permissionUserDTO.getCode(),permissionUserDTO.getRoleName());
        return ResultUtil.success(permissionUserDTOService.findByName(permissionUserDTO.getName()));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个用户管理信息")
    public Result<Object> delete(@RequestParam("code") int code){
        permissionUserRoleService.deleteByUserCode(code);
        permissionUserDTOService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户管理信息")
    public Result<List<PermissionUserDTO>> findAll(){
        return ResultUtil.success(permissionUserDTOService.findAll());
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "根据用户名查找用户信息")
    public Result<PermissionUserDTO> findByName(@RequestParam("name") String name){
     return ResultUtil.success(permissionUserDTOService.findByName(name));
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据用户编码查找用户信息")
    public Result<PermissionUserDTO> findByCode(@RequestParam("code") int code){
        return ResultUtil.success(permissionUserDTOService.findByCode(code));
    }
}
