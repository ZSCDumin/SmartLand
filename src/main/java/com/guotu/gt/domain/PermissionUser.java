package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户信息表
 * @author YalandHong
 *
 */
@ApiModel("用户信息实体")
@Data
@AllArgsConstructor
public class PermissionUser {
    @ApiModelProperty("编码，主键")
    private String code;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty(value = "性别", allowableValues = "男，女")
    private String sex;

    @ApiModelProperty("所属机构编码，外键")
    private String departmentCode;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("电话号码")
    private String contact;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("岗位名称")
    private String description;

    @ApiModelProperty(value = "是否启用", allowableValues = "0不启用，1启用")
    private Byte enable;
}
