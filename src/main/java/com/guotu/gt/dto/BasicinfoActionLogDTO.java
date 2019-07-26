package com.guotu.gt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description = "操作日志管理界面数据")
@Data
@AllArgsConstructor
public class BasicinfoActionLogDTO {
    @ApiModelProperty("操作编码")
    private Byte code;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("机构名称")
    private String departmentName;

    @ApiModelProperty("操作对象")
    private String optObject;

    @ApiModelProperty("操作描述")
    private String description;

    @ApiModelProperty("操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date optTime;
}
