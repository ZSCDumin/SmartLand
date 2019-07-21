package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 模块信息表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "模块信息实体")
public class PermissionModel {

    /**
     * 主键
     */
    @ApiModelProperty("模块编码，主键")
    private Byte code;

    @ApiModelProperty("模块名称")
    private String name;

    @ApiModelProperty("图标文件存储路径")
    private String path;

    @ApiModelProperty("模块显示排序序号")
    private Integer rank;

}