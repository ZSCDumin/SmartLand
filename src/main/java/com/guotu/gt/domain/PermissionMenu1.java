package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 一级菜单信息表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "一级菜单信息实体")
public class PermissionMenu1 {

    /**
     * 主键
     */
    @ApiModelProperty("一级菜单编码，主键")
    private Byte code;

    @ApiModelProperty("一级菜单名称")
    private String name;

    @ApiModelProperty("图标文件存储路径")
    private String path;

    @ApiModelProperty("模块显示排序序号")
    private Integer rank;

    /**
     * 模块信息表的外键
     */
    @ApiModelProperty("所属模块编码，外键")
    private Byte model_code;
}