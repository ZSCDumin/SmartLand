package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户信息DTO")
@Data
public class PermissionUserDTO {

    @ApiModelProperty("用户编码")
    private int code;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("电话号码")
    private String contact;

    @ApiModelProperty("角色")
    private String roleName;

    @ApiModelProperty("所属机构")
    private String department;
}
