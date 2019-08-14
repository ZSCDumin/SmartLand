package com.guotu.gt.controller;


import com.guotu.gt.domain.BasicinfoDepartment;
import com.guotu.gt.dto.BasicinfoDepartmentDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.BasicinfoDepartmentService;
import com.guotu.gt.service.BasicinfoRegionService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/basicinfodepartment")
@Api(tags = "机构信息")
public class BasicinfoDepartmentController {
    @Autowired
    private BasicinfoDepartmentService basicinfoDepartmentService;

    @Autowired
    private BasicinfoRegionService basicinfoRegionService;

    @PutMapping
    @ApiOperation(value="增加一个机构信息")
    public Result<BasicinfoDepartmentDTO> add(@RequestBody BasicinfoDepartment basicinfoDepartment){
        Assert.notNull(basicinfoDepartmentService.findByCode(basicinfoDepartment.getDepartmentCode()),"所属机构编码不存在");
        Assert.notNull(basicinfoRegionService.findByCode(basicinfoDepartment.getRegionId()),"所属行政区域不存在");
        String s1;
        String s2;
        s1=basicinfoRegionService.findByCode(basicinfoDepartment.getRegionId()).getRegionName();
        s2=basicinfoDepartment.getName();
        basicinfoDepartment.setName(s1+s2);
        basicinfoDepartmentService.add(basicinfoDepartment);
        return ResultUtil.success(basicinfoDepartmentService.findByCode(basicinfoDepartment.getCode()));
    }

    @PostMapping
    @ApiOperation(value = "更新一个机构信息")
    public Result<BasicinfoDepartmentDTO> update(@RequestBody BasicinfoDepartment basicinfoDepartment){
        Assert.notNull(basicinfoDepartmentService.findByCode(basicinfoDepartment.getDepartmentCode()),"所属机构编码不存在");
        Assert.notNull(basicinfoRegionService.findByCode(basicinfoDepartment.getRegionId()),"所属行政区域不存在");
        String s1;
        String s2;
        s1=basicinfoRegionService.findByCode(basicinfoDepartment.getRegionId()).getRegionName();
        s2=basicinfoDepartment.getName();
        basicinfoDepartment.setName(s1+s2);
        basicinfoDepartmentService.update(basicinfoDepartment);
        return ResultUtil.success(basicinfoDepartmentService.findByCode(basicinfoDepartment.getCode()));
    }

    @DeleteMapping
    @ApiOperation(value = "根据code删除一个机构信息")
    public Result<Object> delete(@RequestParam("code")@ApiParam(value = "机构编码") int code){
        if(basicinfoDepartmentService.findByParent(code).size()==0){
            basicinfoDepartmentService.delete(code);
            return ResultUtil.success(code);
        }
        else{
            return ResultUtil.error("存在下级机构");
        }
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据code查询机构信息")
    public Result<BasicinfoDepartmentDTO> findByCode(@RequestParam("code")@ApiParam(value = "机构编码") int code){
        return ResultUtil.success(basicinfoDepartmentService.findByCode(code));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有机构信息(机构名带行政区名)")
    public Result<List<BasicinfoDepartmentDTO>> findAll(){
        return ResultUtil.success(basicinfoDepartmentService.findAll());
    }

    @GetMapping("/findAll2")
    @ApiOperation(value = "查询所有机构信息(机构名不带行政区名)")
    public Result<List<BasicinfoDepartmentDTO>> findAll2(){
        List<BasicinfoDepartmentDTO> basicinfoDepartmentDTOs=basicinfoDepartmentService.findAll();
        List<BasicinfoDepartmentDTO> basicinfoDepartmentDTOS2=new ArrayList<>();
        BasicinfoDepartmentDTO temp = new BasicinfoDepartmentDTO();
        int num;
        for(int i=0;i<basicinfoDepartmentDTOs.size();i++){
            temp=basicinfoDepartmentDTOs.get(i);
            if(temp.getRegion()!=null)
                num=temp.getRegion().length();
            else if (temp.getCountry()!=null)
                num=temp.getCountry().length();
            else if(temp.getProvince()!=null)
                num=temp.getProvince().length();
            else
                num=0;
            temp.setName(temp.getName().substring(num));
            basicinfoDepartmentDTOS2.add(temp);
        }
        return ResultUtil.success(basicinfoDepartmentDTOS2);
    }
}
