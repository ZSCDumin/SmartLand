package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 菜单操作分配表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "菜单操作分配实体")
public class PermissionMenu2Operation {

    /**
     * 二级菜单信息表的外键
     */
    @ApiModelProperty("菜单编码，外键")
    private int menu2Code;

    /**
     * 操作信息表的外键
     */
    @ApiModelProperty("操作编码，外键")
    private int operationCode;

}