package com.guotu.gt.controller;

import com.guotu.gt.dto.BasicinfoActionLogDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoActionLogService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 操作日志管理界面 - 控制层
 *
 * @author YalandHong
 */

@RestController
@Api(tags = "操作日志管理界面")
@RequestMapping("/basicinfoActionLog")
public class BasicinfoActionLogController {

    // 注意：只能有一个RequestBody！
    @GetMapping("/getPeriod")
    @ApiOperation(value = "获取时间段内的所有操作")
    public Result<List<BasicinfoActionLogDTO>> getActionByPeriod(
            @ApiParam(value = "开始时间", required = true, example = "2019-01-02 12:34:56")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
            @ApiParam(value = "结束时间", required = true, example = "2019-09-10 11:12:59")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        return ResultUtil.success(basicinfoActionLogService.selectByPeriod(startTime, endTime));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据编码删除操作")
    public Result<Object> deleteByCode(@ApiParam(value = "操作编码", required = true) @RequestParam byte code) {
        basicinfoActionLogService.deleteByCode(code);
        return ResultUtil.success();
    }

    @Autowired
    private BasicinfoActionLogService basicinfoActionLogService;
}
