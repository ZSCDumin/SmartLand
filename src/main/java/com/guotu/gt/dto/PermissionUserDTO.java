package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("用户信息DTO")
@Data
public class PermissionUserDTO {

    @ApiModelProperty("用户编码")
    @NotNull(message = "用户编码不能为空")
    private int code;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空白，必须至少包含一个有效字符")
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
