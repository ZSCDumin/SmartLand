package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.Result;
import com.guotu.gt.dto.UserManagementDTO;
import com.guotu.gt.service.PermissionRoleMenu2OperationService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermanagement")
@Api(tags = "角色权限管理界面")
public class PermissionRoleMenu2OperationController {
    @Autowired
    private PermissionRoleMenu2OperationService permissionRoleMenu2OperationService;

    @PutMapping
    @ApiOperation("修改角色权限")
    public Result<Object> change(@RequestBody @ApiParam(value = "角色操纵权限列表") List<PermissionRoleMenu2Operation> permissionRoleMenu2OperationList,
                                 @RequestParam(value = "roleCode") @ApiParam(value = "角色编码") int roleCode){
        permissionRoleMenu2OperationService.deleteByRoleCode(roleCode);
        permissionRoleMenu2OperationService.insert(permissionRoleMenu2OperationList);
        return ResultUtil.success();
    }

    @GetMapping
    @ApiOperation("获取角色权限信息")
    public Result<List<UserManagementDTO>> open(@RequestParam(value = "roleCode") @ApiParam(value = "角色编码")int roleCode){
        return ResultUtil.success(permissionRoleMenu2OperationService.open(roleCode));
    }
}
