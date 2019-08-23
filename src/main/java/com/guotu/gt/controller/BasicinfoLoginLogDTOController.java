package com.guotu.gt.controller;

import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoLoginLogDTOService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/basicinfologinlogdto")
@Api(tags = "登录日志管理")
public class BasicinfoLoginLogDTOController {

    @Autowired
    private BasicinfoLoginLogDTOService basicinfoLoginLogDTOService;

    @DeleteMapping
    @ApiOperation("根据编码删除一条登录日志")
    public Result<Integer> delete(@RequestParam("code") int code){
        Assert.notNull(basicinfoLoginLogDTOService.findByLogCode(code),"该条日志不存在");
        basicinfoLoginLogDTOService.delete(code);
        return ResultUtil.success(code);
    }

    @GetMapping("/search")
    @ApiOperation(value = "根据输入的日期范围查询",
            notes = "日期格式为YYYY-MM-DD  \n结束日期必须等于或晚于开始日期"
                    + "  \n查询范围从开始日期0时0分0秒到结束日期23时59分59秒")
    public Result<List<BasicinfoLoginLogDTO>> search(
            @ApiParam(value = "开始日期", required = true) @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @ApiParam(value = "结束日期", required = true) @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        return ResultUtil.success(basicinfoLoginLogDTOService.search(start,end));
    }

    @GetMapping("/searchByPage")
    @ApiOperation(value = "根据输入的日期范围进行分页查询",
            notes = "需要提供页码和每一页的大小  \n日期格式为YYYY-MM-DD  \n结束日期必须等于或晚于开始日期"
                    + "  \n查询范围从开始日期0时0分0秒到结束日期23时59分59秒")
    public Result<PageBean<BasicinfoLoginLogDTO>> searchByPage(
            @ApiParam(value = "开始日期", required = true) @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @ApiParam(value = "结束日期", required = true) @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") int page,
            @ApiParam(value = "每页的条目数") @RequestParam(defaultValue = "10") int size) {
        Assert.isTrue(size > 0, "页码必须是正整数");
        return ResultUtil.success(basicinfoLoginLogDTOService.searchByPage(start,end, page, size));
    }

    @GetMapping("/open")
    @ApiOperation("获取所有登录日志")
    public Result<List<BasicinfoLoginLogDTO>> open(){
        return ResultUtil.success(basicinfoLoginLogDTOService.open());
    }

    @GetMapping("/openByPage")
    @ApiOperation(value = "分页获取登录日志", notes = "需要提供页码和每一页的大小")
    public Result<PageBean<BasicinfoLoginLogDTO>> openByPage(
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") int page,
            @ApiParam(value = "每页的条目数") @RequestParam(defaultValue = "10") int size) {
        Assert.isTrue(size > 0, "页码必须是正整数");
        return ResultUtil.success(basicinfoLoginLogDTOService.openByPage(page, size));
    }

}
