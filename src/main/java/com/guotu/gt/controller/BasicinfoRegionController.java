package com.guotu.gt.controller;

import com.guotu.gt.domain.BasicinfoRegion;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoRegionService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basicinforegion")
@Api(tags = "地区信息查询")
public class BasicinfoRegionController {
    @Autowired
    BasicinfoRegionService basicinfoRegionService;

    @GetMapping("/bycode")
    @ApiOperation("根据地区编码查询")
    public Result<BasicinfoRegion> findByCode(@RequestParam int code){
        return ResultUtil.success(basicinfoRegionService.findByCode(code));
    }

    @GetMapping("/bylevel")
    @ApiOperation(value ="根据地区等级查询",notes = "地区等级分3级，1为省，2为市，3为县市区")
    public Result<List<BasicinfoRegion>> findByLevel( @RequestParam int level){
        return ResultUtil.success(basicinfoRegionService.findByLevel(level));
    }

    @GetMapping("/byparent")
    @ApiOperation(value ="根据上级地区查询")
    public Result<List<BasicinfoRegion>> findByParent( @RequestParam int parentId){
        return ResultUtil.success(basicinfoRegionService.findByParent(parentId));
    }

    @GetMapping("/all")
    @ApiOperation(value ="查询所有地区")
    public Result<List<BasicinfoRegion>> findAll(){
        return ResultUtil.success(basicinfoRegionService.findAll());
    }
}
