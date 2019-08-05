package com.guotu.gt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("用户登录日志信息DTO")
@Data
public class BasicinfoLoginLogDTO {

    @ApiModelProperty(value = "用户登录日志信息编码", required = true)
    private int code;

    @ApiModelProperty(value = "用户名称", required = true)
    private String name;

    @ApiModelProperty("所在机构")
    private String department;

    @ApiModelProperty(value = "登录IP地址", required = true)
    private String ipAddress;

    @ApiModelProperty("登录机器名称")
    private String machineName;  //null

    @ApiModelProperty("登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
    private Date logTime;
}
