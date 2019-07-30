package com.guotu.gt.controller;

import com.guotu.gt.domain.BasicinfoActionLog;
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
    @GetMapping("/search")
    @ApiOperation(value = "获取时间段内的所有操作")
    public Result<List<BasicinfoActionLogDTO>> getActionByPeriod(
            @ApiParam(value = "开始时间", required = true, example = "2019-01-02")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @ApiParam(value = "结束时间", required = true, example = "2019-09-10")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        return ResultUtil.success(basicinfoActionLogService.selectByPeriod(startTime, endTime));
    }

    @GetMapping("/open")
    @ApiOperation(value = "获取所有操作记录")
    public Result<List<BasicinfoActionLogDTO>> getAllAction() {
        return ResultUtil.success(basicinfoActionLogService.selectAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据编码删除操作")
    public Result<Object> deleteByCode(@ApiParam(value = "操作编码", required = true)
                                           @RequestParam Integer code) {
        basicinfoActionLogService.deleteByCode(code);
        return ResultUtil.success();
    }

    @Autowired
    private BasicinfoActionLogService basicinfoActionLogService;


    // TEST
    /*@GetMapping("/getByCode")
    public Result<BasicinfoActionLog> selectByCode(@ApiParam(required = true, type = "integer")
                                                       @RequestParam Byte code) {
        return ResultUtil.success(basicinfoActionLogService.selectByCode(code));
    }*/

    /*@PutMapping("/insert")
    public Result<Object> insert(@ApiParam(required = true) @RequestParam Byte code) {
        Date now = new Date();
        System.out.println(now.toString());
        basicinfoActionLogService.insert(
                new BasicinfoActionLog(code, "2", "A", "B", "C", "D", now));
        return ResultUtil.success();
    }*/
}
