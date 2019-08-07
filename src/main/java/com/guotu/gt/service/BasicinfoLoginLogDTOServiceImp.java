package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoLoginLog;
import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import com.guotu.gt.mapper.BasicinfoLoginLogDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<BasicinfoLoginLogDTO> search(Date start, Date end){
        return basicinfoLoginLogDTOMapper.search(start,end);
    }

    @Override
    public List<BasicinfoLoginLogDTO> open(){
        return basicinfoLoginLogDTOMapper.open();
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
