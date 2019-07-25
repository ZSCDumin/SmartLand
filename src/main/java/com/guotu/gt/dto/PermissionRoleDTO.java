package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "角色管理界面数据实体")
@Data
@AllArgsConstructor
public class PermissionRoleDTO {
    
    @ApiModelProperty("角色编码")
    private Byte code;

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
