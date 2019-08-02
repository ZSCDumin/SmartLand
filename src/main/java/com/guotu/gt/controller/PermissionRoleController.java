package com.guotu.gt.controller;

import com.guotu.gt.constant.OperationType;
import com.guotu.gt.domain.BasicinfoActionLog;
import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoActionLogService;
import com.guotu.gt.service.PermissionRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 角色管理界面 - 控制层
 *
 * @author YalandHong
 */

@RestController
@Api(tags = "角色管理界面")
@RequestMapping("/permissionRole")
public class PermissionRoleController {

    @GetMapping(value = "/all")
    @ApiOperation(value = "获取所有角色")
    public Result<List<PermissionRoleDTO>> getAllRole() {
        return ResultUtil.success(permissionRoleService.selectAll());
    }

    @GetMapping(value = "/allRoleName")
    @ApiOperation(value = "获取所有角色的姓名", notes = "用于限制用户输入的角色名，保证角色名合法")
    public Result<List<String>> getAllRoleName() {
        return ResultUtil.success(permissionRoleService.selectAllRoleName());
    }

    @PostMapping("/update")
    @ApiOperation(value = "根据编码修改角色", notes = "只能更新角色的名字和描述。返回修改之前的角色信息")
    public Result<Object> updateByCode(@RequestBody PermissionRoleDTO permissionRoleDTO,
                                       @ApiParam(value = "执行操作的用户编码", required = true)
                                       @RequestParam Integer operatorCode) {
        PermissionRoleDTO oldRole = permissionRoleService.updateByCode(permissionRoleDTO);

        // 记录操作日志
        // TODO test
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.UPDATE,
                "角色\"" + oldRole.getName() + "\"", new Date());

        return ResultUtil.success(oldRole);
    }

    @PutMapping("/add")
    @ApiOperation(value = "新增一个角色")
    public Result<PermissionRoleDTO> addNewRole(@ApiParam(value = "角色名称", required = true) @RequestParam String name,
                    @ApiParam(value = "角色描述") @RequestParam(required = false) String description) {
        Result<PermissionRoleDTO> result = ResultUtil.success(permissionRoleService.insert(name, description));
        // TODO log
        return result;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据编码删除一个角色",
            notes = "删除一个用户添加的角色，系统创建的角色不能删除。关联用户的角色会变成普通用户，同时角色相应的权限分配会被删除")
    public Result<Object> deleteByCode(@ApiParam(value = "角色编码", required = true) @RequestParam Integer code) {
        permissionRoleService.deleteByCode(code);
        // TODO log
        return ResultUtil.success();
    }

    @Autowired
    private PermissionRoleService permissionRoleService;

    @Autowired
    private BasicinfoActionLogService basicinfoActionLogService;

    private static final String INTERFACE_NAME = "角色管理";
}
