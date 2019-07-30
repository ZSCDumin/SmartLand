package com.guotu.gt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户操作日志信息表
 * @author YalandHong
 *
 */
@ApiModel("用户操作日志信息实体")
@Data
@AllArgsConstructor
public class BasicinfoActionLog {
    @ApiModelProperty("编码，主键")
    private Integer code;
    
    @ApiModelProperty("用户编号，外键")
    private String userCode;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("操作对象")
    private String optObject;

    @ApiModelProperty("操作类型")
    private String optType;

    @ApiModelProperty("操作数据描述")
    private String description;

    @ApiModelProperty("操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  // 规定日期格式和时区
    private Date optTime;
}
