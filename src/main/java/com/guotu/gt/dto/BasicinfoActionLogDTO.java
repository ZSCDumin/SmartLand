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
    @ApiModelProperty(value = "操作日志条目编码", required = true)
    private Integer code;

    @ApiModelProperty(value = "执行操作的用户名", required = true)
    private String name;

    @ApiModelProperty(value = "机构名称", required = true)
    private String departmentName;

    @ApiModelProperty(value = "操作的模块或界面的名称", required = true)
    private String optObject;

    @ApiModelProperty(value = "操作描述", required = true)
    private String description;

    @ApiModelProperty(value = "操作时间", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  // 规定日期格式和时区
    private Date optTime;
}
