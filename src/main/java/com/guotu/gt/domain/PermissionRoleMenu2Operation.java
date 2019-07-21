package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 角色权限分配表
 * @author YalandHong
 *
 */
@ApiModel("角色权限分配实体")
@Data
@AllArgsConstructor
public class PermissionRoleMenu2Operation {
    
    @ApiModelProperty("角色编码，外键")
    private Byte roleCode;
    
    @ApiModelProperty("菜单编码，外键")
    private Byte menu2Code;

    @ApiModelProperty("操作编码，外键")
    private Byte operationCode;
}
