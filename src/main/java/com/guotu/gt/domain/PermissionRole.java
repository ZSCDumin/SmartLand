package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 角色信息表
 * @author YalandHong
 *
 */
@ApiModel(description = "角色信息实体")
@Data
@AllArgsConstructor
public class PermissionRole {
    // TODO 主键是写在注释里还是注解里？
    @ApiModelProperty("角色编码，主键")
    private Byte code;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色描述说明")
    private String description;

    // TODO 备注问题
    @ApiModelProperty(value = "标志位", notes = "0表示系统创建")
    private Byte flag;
}
