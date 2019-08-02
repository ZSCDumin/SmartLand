package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "角色管理界面数据实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRoleDTO {
    
    @ApiModelProperty(value = "角色编码")
    private Integer code;

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
