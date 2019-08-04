package com.guotu.gt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("操作日志管理界面数据")
@Data
@AllArgsConstructor
public class BasicinfoActionLogDTO {
    @ApiModelProperty(value = "操作日志条目编码")
    private Integer code;

    @ApiModelProperty("执行操作的用户名")
    private String name;

    @ApiModelProperty("机构名称")
    private String departmentName;

    @ApiModelProperty("操作的模块或界面的名称")
    private String optObject;

    @ApiModelProperty("操作描述")
    private String description;

    @ApiModelProperty("操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  // 规定日期格式和时区
    private Date optTime;
}
