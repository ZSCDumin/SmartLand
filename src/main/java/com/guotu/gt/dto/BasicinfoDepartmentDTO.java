package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "机构信息DTO")
public class BasicinfoDepartmentDTO {

    /**
     * 主键
     */
    @ApiModelProperty("机构编码，主键")
    private int institutionCode;

    @ApiModelProperty("机构名称")
    private String name;

    @ApiModelProperty("机构信息")
    private String info;

    /**
     * 机构信息表的机构编码的外键
     */
    @ApiModelProperty("所属机构编码，外键")
    private int departmentCode;

    @ApiModelProperty("所属机构名称")
    private String departmentName;

    @ApiModelProperty("区")
    private String region;

    @ApiModelProperty("县")
    private String country;

    @ApiModelProperty("省")
    private String province;
}
