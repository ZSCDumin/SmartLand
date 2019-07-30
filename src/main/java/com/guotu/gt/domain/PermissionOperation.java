package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 操作信息表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "操作信息实体")
public class PermissionOperation {

    /**
     * 主键
     */
    @ApiModelProperty("操作编码，主键")
    private int code;

    /**
     *系统默认操作类型：0浏览；1新增；2查询；3删除；4编辑；5审核
     */
    @ApiModelProperty("操作类型")
    private String name;

}
