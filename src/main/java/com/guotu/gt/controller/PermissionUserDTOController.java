package com.guotu.gt.controller;

import com.guotu.gt.constant.OperationType;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.dto.PermissionUserDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoActionLogService;
import com.guotu.gt.service.PermissionUserDTOService;
import com.guotu.gt.service.PermissionUserRoleService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ApiOperation(value="增加一个用户信息")
    public Result<PermissionUserDTO> add(@RequestBody @Valid PermissionUserDTO permissionUserDTO,
                                         @ApiParam(value = "执行操作的用户编码", required = true)
                                         @RequestParam Integer operatorCode) {
        // 重名判断
        Assert.isNull(permissionUserDTOService.findByName(permissionUserDTO.getName()),
                "已经存在一个名为\"" + permissionUserDTO.getName() + "\"的用户");

        permissionUserDTOService.add(permissionUserDTO);
        permissionUserRoleService.insertCodeName(permissionUserDTO.getCode(),permissionUserDTO.getRoleName());
        //记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.INSERT,
                "用户\"" + permissionUserDTO.getName() + "\"");
        // 将插入后的用户返回给前端
        return ResultUtil.success(permissionUserDTOService.findByName(permissionUserDTO.getName()));
    }

    @PostMapping
    @ApiOperation(value = "更新一个用户信息")
    public Result<PermissionUserDTO> update(@RequestBody @Valid PermissionUserDTO permissionUserDTO,
                                            @ApiParam(value = "执行操作的用户编码", required = true)
                                            @RequestParam Integer operatorCode){
        // 获取更新之前的用户
        PermissionUserDTO oldUser = permissionUserDTOService.findByCode(permissionUserDTO.getCode());
        Assert.notNull(oldUser, "不存在编码为" + permissionUserDTO.getCode() + "的用户");

        // 重名判断
        PermissionUserDTO checkUser = permissionUserDTOService.findByName(permissionUserDTO.getName());
        Assert.isTrue((checkUser == null) || (checkUser.getCode() == permissionUserDTO.getCode()),
                "已经存在一个名为\"" + permissionUserDTO.getName() + "\"的用户");

        // 更新用户信息
        permissionUserDTOService.update(permissionUserDTO);
        permissionUserRoleService.updateCodeName(permissionUserDTO.getCode(),permissionUserDTO.getRoleName());
        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.UPDATE,
                "用户\"" + oldUser.getName() + "\"");
        // 将更新之后的结果返回给前端
        return ResultUtil.success(permissionUserDTOService.findByName(permissionUserDTO.getName()));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个用户信息")
    public Result<Integer> delete(@RequestParam("code") int code,
                                  @ApiParam(value = "执行操作的用户编码", required = true)
                                  @RequestParam Integer operatorCode){
        // 获取删除的用户
        PermissionUserDTO deletedUser = permissionUserDTOService.findByCode(code);
        Assert.notNull(deletedUser, "不存在编码为" + code + "的用户");

        // 删除用户以及关联数据
        permissionUserRoleService.deleteByUserCode(code);
        basicinfoActionLogService.deleteByUserCode(code);
        permissionUserDTOService.delete(code);
        // 记录操作日志
        basicinfoActionLogService.insert(operatorCode, INTERFACE_NAME, OperationType.DELETE,
                    "用户\"" + deletedUser.getName() + "\"");
        // 将删除的用户编码返回给前端
        return ResultUtil.success(code);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户信息")
    public Result<List<PermissionUserDTO>> findAll(){
        return ResultUtil.success(permissionUserDTOService.findAll());
    }

    @GetMapping("/findAllByPage")
    @ApiOperation(value = "分页查询用户信息")
    public Result<PageBean<PermissionUserDTO>> findAllByPage(
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") int page,
            @ApiParam(value = "每页的条目数") @RequestParam(defaultValue = "10") int size){
        Assert.isTrue(size > 0, "页码必须是正整数");
        return ResultUtil.success(permissionUserDTOService.findAllByPage(page, size));
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

    // 操作日志
    @Autowired
    BasicinfoActionLogService basicinfoActionLogService;

    private static final String INTERFACE_NAME = "用户管理";
}
