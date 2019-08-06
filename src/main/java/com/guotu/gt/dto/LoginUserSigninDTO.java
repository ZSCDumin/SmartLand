package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户登录时输入的信息
 * @author YalandHong
 */

@ApiModel("用户登录时传入信息")
@Data
@AllArgsConstructor
public class LoginUserSigninDTO {
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "IP地址", required = true)
    @NotBlank(message = "IP地址不能为空")
    private String ipAddress;

    @ApiModelProperty("机器名")
    private String machineName;
}
