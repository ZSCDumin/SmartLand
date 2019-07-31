package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.Result;
import com.guotu.gt.dto.UserManagementDTO;
import com.guotu.gt.service.PermissionRoleMenu2OperationService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usermanagement")
public class PermissionRoleMenu2OperationController {
    @Autowired
    private PermissionRoleMenu2OperationService permissionRoleMenu2OperationService;

    @PostMapping
    @ApiOperation("修改角色权限")
    public Result<Object> change(List<PermissionRoleMenu2Operation> permissionRoleMenu2OperationList, int roleCode){
        permissionRoleMenu2OperationService.deleteByRoleCode(roleCode);
        permissionRoleMenu2OperationService.insert(permissionRoleMenu2OperationList);
        return ResultUtil.success();
    }

    @GetMapping
    @ApiOperation("获取角色权限信息")
    public Result<UserManagementDTO> open(int roleCode){
        return ResultUtil.success(permissionRoleMenu2OperationService.open(roleCode));
    }
}
