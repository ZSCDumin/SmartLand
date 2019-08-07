package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("权限管理DTO")
@Data
public class UserManagementDTO {
    @ApiModelProperty("操作名称")
    private String operationName;

    @ApiModelProperty("操作编码")
    private int operationCode;

    @ApiModelProperty("二级菜单名称")
    private String menu2Name;

    @ApiModelProperty("二级菜单编码")
    private int menu2Code;

    @ApiModelProperty("角色名")
    private String roleName;

}
