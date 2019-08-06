package com.guotu.gt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户登录成功之后返回的信息
 * @author YalandHong
 */

@ApiModel("用户登录返回信息")
@Data
@AllArgsConstructor
public class LoginUserDTO {
    @ApiModelProperty(value = "用户编码", required = true)
    private Integer userCode;

    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @ApiModelProperty(value = "角色编码", required = true)
    private Integer roleCode;

    /*@ApiModelProperty("角色名")
    private String roleName;*/
}
