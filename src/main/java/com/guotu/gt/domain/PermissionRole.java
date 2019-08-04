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
@ApiModel("角色信息实体")
@Data
@AllArgsConstructor
public class PermissionRole {
    @ApiModelProperty("角色编码，主键")
    private Integer code;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色描述说明")
    private String description;  // null
	
    @ApiModelProperty(value = "标志位", notes = "标志位：0表示系统创建，不允许删除")
    private Integer flag;
}
