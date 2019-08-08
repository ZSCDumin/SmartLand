package com.guotu.gt.controller;

import com.guotu.gt.constant.OperationType;
import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.*;
import com.guotu.gt.service.BasicinfoActionLogService;
import com.guotu.gt.service.PermissionMenu2OperationService;
import com.guotu.gt.service.PermissionRoleMenu2OperationService;
import com.guotu.gt.service.PermissionRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authoritymanagement")
@Api(tags = "角色权限管理界面")
public class PermissionRoleMenu2OperationController {
    @Autowired
    private PermissionRoleMenu2OperationService permissionRoleMenu2OperationService;

    @Autowired
    private PermissionRoleService permissionRoleService;

    @Autowired
    private PermissionMenu2OperationService permissionMenu2OperationService;

    @Autowired
    private BasicinfoActionLogService basicinfoActionLogService;

    @PutMapping
    @ApiOperation(value="修改角色权限",
                  notes = "只需要传该角色的编码和拥有的权限的菜单编码和操作编码即可")
    public Result<Object> change(@ApiParam(value = "角色操纵权限列表") 
								@RequestBody List<PermissionRoleMenu2OperationDTO> permissionRoleMenu2OperationDTOList,
                                 @RequestParam @ApiParam(value = "角色编码", required = true) int roleCode,
                                 @ApiParam(value = "执行操作的用户编码", required = true) @RequestParam Integer operatorCode){
        // 判断角色编码是否合法
        PermissionRoleDTO editRole = permissionRoleService.selectByCode(roleCode);
        Assert.notNull(editRole, "不存在编码为" + roleCode + "的角色");

        // 修改角色权限
        permissionRoleMenu2OperationService.deleteByRoleCode(roleCode);
        List<PermissionRoleMenu2Operation> permissionRoleMenu2Operations= new ArrayList<>();
        PermissionRoleMenu2OperationDTO temp;
        for(int i=0;i<permissionRoleMenu2OperationDTOList.size();i++){
            temp=permissionRoleMenu2OperationDTOList.get(i);
			
			// 判断编码是否为空
			Assert.notNull(temp.getMenu2Code(), "菜单编码不能为空：" + temp.toString());
			Assert.notNull(temp.getOperationCode(), "操作编码不能为空：" + temp.toString());

            // 判断是否存在重复插入的权限
            for (int j = 0; j < i; j++) {
                PermissionRoleMenu2OperationDTO temp2 = permissionRoleMenu2OperationDTOList.get(j);
                Assert.isTrue(!temp.equals(temp2), "存在重复的权限：" + temp.toString() + "和" + temp2.toString());
            }

            // 判断该权限是否合法
            Assert.isTrue(permissionMenu2OperationService.checkExists(temp.getMenu2Code(), temp.getOperationCode()),
                    "存在非法的菜单编码或操作编码：" + temp.toString());

            permissionRoleMenu2Operations.add(
                    new PermissionRoleMenu2Operation(roleCode,temp.getMenu2Code(),temp.getOperationCode()));
        }
        permissionRoleMenu2OperationService.insert(permissionRoleMenu2Operations);

        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.UPDATE,
                "角色\"" + editRole.getName() + "\"的权限");
        return ResultUtil.success();
    }

    @GetMapping("/all")
    @ApiOperation("获取角色权限信息")
    public Result<List<UserManagementDTO>> open(@RequestParam @ApiParam(value = "角色编码", required = true) int roleCode){
        Assert.notNull(permissionRoleService.selectByCode(roleCode), "不存在编码为" + roleCode + "的角色");
		return ResultUtil.success(permissionRoleMenu2OperationService.open(roleCode));
    }

    @GetMapping("/allByPage")
    @ApiOperation("分页获取角色权限信息")
    public Result<PageBean<UserManagementDTO>> openByPage(
            @RequestParam @ApiParam(value = "角色编码", required = true) int roleCode,
            @RequestParam(defaultValue = "1") @ApiParam(value = "页码") int page,
            @RequestParam(defaultValue = "10") @ApiParam(value = "页面大小") int size){
        Assert.isTrue(size > 0, "页码必须是正整数");
        Assert.notNull(permissionRoleService.selectByCode(roleCode), "不存在编码为" + roleCode + "的角色");
        return ResultUtil.success(permissionRoleMenu2OperationService.openByPage(roleCode, page, size));
    }

    private static final String INTERFACE_NAME = "权限管理";
}
