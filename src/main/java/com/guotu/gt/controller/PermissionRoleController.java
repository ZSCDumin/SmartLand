package com.guotu.gt.controller;

import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.PermissionRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "角色管理界面")
@RequestMapping("/permissionUser")
public class PermissionRoleController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取所有角色")
    public Result<List<PermissionRoleDTO>> getAllRole() {
        return ResultUtil.success(permissionRoleService.selectAll());
    }

    @PostMapping("/update")
    @ApiOperation(value = "根据编码更新角色", notes = "只能更新角色的名字和描述")
    public void updateByCode(@RequestBody PermissionRoleDTO permissionRoleDTO) {
        permissionRoleService.updateByCode(permissionRoleDTO);
    }

    @PutMapping("/add")
    @ApiOperation(value = "新增一个角色")
    public Result<PermissionRoleDTO> addNewRole(@ApiParam(value = "角色名称", required = true) @RequestParam String name,
                    @ApiParam(value = "角色描述", allowEmptyValue = true) @RequestParam String description) {
        return ResultUtil.success(permissionRoleService.insert(name, description));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据编码删除一个角色")
    public void deleteByCode(@ApiParam(value = "角色编码", required = true) @RequestParam Byte code) {
        permissionRoleService.deleteByCode(code);
    }

    @Autowired
    private PermissionRoleService permissionRoleService;
}