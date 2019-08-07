package com.guotu.gt.controller;

import com.guotu.gt.constant.OperationType;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoActionLogService;
import com.guotu.gt.service.PermissionRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "/allByPage")
    @ApiOperation(value = "分页获取所有角色", notes = "需要提供页码和每一页的大小")
    public Result<PageBean<PermissionRoleDTO>> getAllRoleByPage(
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") int page,
            @ApiParam(value = "每页的条目数") @RequestParam(defaultValue = "10") int size) {
        Assert.isTrue(size > 0, "页码必须是正整数");
        return ResultUtil.success(permissionRoleService.selectAllByPage(page, size));
    }

    @GetMapping(value = "/allRoleName")
    @ApiOperation(value = "获取所有角色的姓名", notes = "用于限制用户输入的角色名，保证角色名合法")
    public Result<List<String>> getAllRoleName() {
        return ResultUtil.success(permissionRoleService.selectAllRoleName());
    }

    @PostMapping("/update")
    @ApiOperation(value = "根据编码修改角色", notes = "更新角色的名字和描述。不能修改系统角色")
    public Result<Object> updateByCode(@RequestBody @Valid PermissionRoleDTO permissionRoleDTO,
                                       BindingResult bindingResult,
                                       @ApiParam(value = "执行操作的用户编码", required = true)
                                       @RequestParam Integer operatorCode) {
        if (bindingResult.hasErrors()) {  // 验证参数合法性
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        PermissionRoleDTO oldRole = permissionRoleService.updateByCode(permissionRoleDTO);
        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.UPDATE,
                "角色\"" + oldRole.getName() + "\"");

        return ResultUtil.success();
    }

    @PutMapping("/add")
    @ApiOperation(value = "新增一个角色", notes = "返回新插入的角色信息")
    public Result<PermissionRoleDTO> addNewRole(@ApiParam(value = "角色名称", required = true) @RequestParam String name,
                    @ApiParam(value = "角色描述") @RequestParam(required = false) String description,
                    @ApiParam(value = "执行操作的用户编码", required = true) @RequestParam Integer operatorCode) {

        PermissionRoleDTO newRole = permissionRoleService.insert(name, description);
        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.INSERT,
                "角色\"" + newRole.getName() + "\"");
        return ResultUtil.success(newRole);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据编码删除一个角色",
            notes = "删除一个用户添加的角色，系统角色不能删除。关联用户的角色会变成普通用户，同时角色相应的权限分配会被删除")
    public Result<Object> deleteByCode(@ApiParam(value = "角色编码", required = true) @RequestParam Integer code,
                    @ApiParam(value = "执行操作的用户编码", required = true) @RequestParam Integer operatorCode) {

        PermissionRoleDTO deletedRole = permissionRoleService.deleteByCode(code);
        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.DELETE,
                "角色\"" + deletedRole.getName() + "\"");
        return ResultUtil.success();
    }

    @Autowired
    private PermissionRoleService permissionRoleService;

    @Autowired
    private BasicinfoActionLogService basicinfoActionLogService;

    private static final String INTERFACE_NAME = "角色管理";
}
