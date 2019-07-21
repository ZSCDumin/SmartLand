package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 机构信息表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "机构信息实体")
 public class BasicInfoDepartment {

    @ApiModelProperty("主键")
    @NotNull(message = "主键不能为空")
    private String code;

    @ApiModelProperty("外键")
    private String departmentCode;

    @ApiModelProperty("机构名称")
    @NotNull(message = "机构名称不能为空")
    private String name;

    @ApiModelProperty("机构信息")
    private String info;

    @ApiModelProperty("所属机构名称")
    private String createPersonId;

}
