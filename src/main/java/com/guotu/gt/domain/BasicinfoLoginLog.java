package com.guotu.gt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户登录日志信息表
 * @author YalandHong
 *
 */
@ApiModel("用户登录日志信息实体")
@Data
@AllArgsConstructor
// TODO 有些变量的命名大小写？
public class BasicinfoLoginLog {
    @ApiModelProperty("编码，主键")
    private Byte code;

    @ApiModelProperty("用户编号，外键")
    private String userCode;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("登录IP地址")
    private String ipAddress;
    
    @ApiModelProperty("登录机器名称")
    private String machineName;  //null
    
    @ApiModelProperty("登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logTime;
}
