package com.guotu.gt.controller;

import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoLoginLogDTOService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/basicinfologinlogdto")
@Api(tags = "用户登录日志管理")
public class BasicinfoLoginLogDTOController {

    @Autowired
    private BasicinfoLoginLogDTOService basicinfoLoginLogDTOService;

    @DeleteMapping
    @ApiOperation("根据编码删除一条登录日志")
    public Result<Object> delete(@RequestParam("code") int code){
        basicinfoLoginLogDTOService.delete(code);
        return ResultUtil.success();
    }

    @GetMapping("/search")
    @ApiOperation("根据输入的日期范围查询")
    public Result<List<BasicinfoLoginLogDTO>> search(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start,
                                                     @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        return ResultUtil.success(basicinfoLoginLogDTOService.search(start,end));
    }

    @GetMapping("/open")
    @ApiOperation("获取所有登录日志")
    public Result<List<BasicinfoLoginLogDTO>> open(){
        return ResultUtil.success(basicinfoLoginLogDTOService.open());
    }

}
