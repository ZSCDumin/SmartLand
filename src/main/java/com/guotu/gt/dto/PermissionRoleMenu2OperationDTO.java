package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色权限分配DTO
 *
 */
@ApiModel("角色权限分配DTO")
@Data
public class PermissionRoleMenu2OperationDTO {
    @ApiModelProperty("菜单编码，外键")
    private Integer menu2Code;

    @ApiModelProperty("操作编码，外键")
    private Integer operationCode;
}
