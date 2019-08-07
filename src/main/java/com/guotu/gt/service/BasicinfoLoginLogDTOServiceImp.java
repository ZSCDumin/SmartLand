package com.guotu.gt.service;

import com.github.pagehelper.PageHelper;
import com.guotu.gt.domain.BasicinfoLoginLog;
import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.mapper.BasicinfoLoginLogDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class BasicinfoLoginLogDTOServiceImp implements BasicinfoLoginLogDTOService {

    @Autowired
    private BasicinfoLoginLogDTOMapper basicinfoLoginLogDTOMapper;

    @Override
    public void delete(int code){
        basicinfoLoginLogDTOMapper.delete(code);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<BasicinfoLoginLogDTO> search(Date start, Date end){

        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        Assert.isTrue(end.after(start), "结束时间必须等于或晚于开始时间");

        System.out.println(start.toString());
        System.out.println(end.toString());

        return basicinfoLoginLogDTOMapper.search(start,end);
    }

    /**
     * 根据输入的日期范围查询
     * @param start 开始日期
     * @param end 结束日期
     * @return 指定页的登录日志
     */
    @Override
    @SuppressWarnings("deprecation")
    public PageBean<BasicinfoLoginLogDTO> searchByPage(Date start, Date end, Integer pageNum, Integer pageSize) {
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        Assert.isTrue(end.after(start), "结束时间必须等于或晚于开始时间");
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(basicinfoLoginLogDTOMapper.search(start,end));
    }

    @Override
    public List<BasicinfoLoginLogDTO> open(){
        return basicinfoLoginLogDTOMapper.open();
    }

    /**
     * 分页获取登录日志
     * @return 指定页码的登录日志
     */
    @Override
    public PageBean<BasicinfoLoginLogDTO> openByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(basicinfoLoginLogDTOMapper.open());
    }

    /**
     * 新增一个登录日志
     * @param userCode 登录用户的编码
     * @param ipAddress 登录IP
     * @param machineName 登录机器名
     */
    @Override
    public void insert(Integer userCode, String ipAddress, String machineName) {
        // 用户编码在登录的时候进行校验，此处不需要重复校验
        // 插入登录日志
        basicinfoLoginLogDTOMapper.insert(
                new BasicinfoLoginLog(null, userCode, ipAddress, machineName, new Date()));
    }
}
