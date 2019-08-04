package com.guotu.gt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("地区信息实体")
@Data
public class basicinfoRegion {
    @ApiModelProperty("地区ID，主键")
    Integer regionId;

    @ApiModelProperty("地区名称")
    String regionName;

    @ApiModelProperty("行政地区代码")
    String XZDQDM;

    @ApiModelProperty("地区上级ID")
    Integer regionParentId;

    @ApiModelProperty("地区级别")
    Integer regionLevel;
}
