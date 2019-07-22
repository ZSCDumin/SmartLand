package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 机构信息表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "机构信息实体")
public class BasicInfoDepartment {

   /**
    * 主键
    */
   @ApiModelProperty("机构编码，主键")
   private String code;

   @ApiModelProperty("机构名称")
   private String name;

   @ApiModelProperty("机构信息")
   private String info;

   /**
    * 机构信息表的机构编码的外键
    */
   @ApiModelProperty("所属机构编码，外键")
   private String departmentCode;

   @ApiModelProperty("所属机构名称")
   private String createPersonId;

}
