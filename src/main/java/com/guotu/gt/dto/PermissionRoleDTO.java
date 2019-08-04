package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@ApiModel("角色管理界面数据实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRoleDTO {
    
    @ApiModelProperty(value = "角色编码", required = true)
    @NotNull(message = "角色编码不能为空")
    private Integer code;

    @ApiModelProperty(value = "角色名", required = true)
    @NotNull(message = "角色名称不能为空")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
