package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录时输入的信息
 * @author YalandHong
 */

@ApiModel("用户登录输入信息")
@Data
@AllArgsConstructor
public class LoginUserSigninDTO {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
