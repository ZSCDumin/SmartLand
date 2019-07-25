package com.guotu.gt.controller;

import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "角色管理界面")
@RequestMapping("/permissionUser")
public class PermissionRoleController {

    @GetMapping("/all")
    @ApiOperation(value = "获取所有角色")
    public Result<List<PermissionRoleDTO>> getAllRole() {
        return ResultUtil.success(permissionRoleService.selectAll());
    }

    @Autowired
    PermissionRoleService permissionRoleService;
}
