package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户角色分配表
 * @author YalandHong
 *
 */
@ApiModel("用户角色分配实体")
@Data
@AllArgsConstructor
public class PermissionUserRole {
    @ApiModelProperty("用户编码，外键")
    private Integer userCode;

    @ApiModelProperty("角色编码，外键")
    private Integer roleCode;
}
