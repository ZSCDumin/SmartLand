package com.guotu.gt.service;

import com.guotu.gt.dto.BasicinfoLoginLogDTO;

import java.util.Date;
import java.util.List;


public interface BasicinfoLoginLogDTOService {

    /**
     * 根据编码删除选中用户登录信息
     * @param code
     * @return
     */
    void delete(int code);

    /**
     * 根据输入的日期范围查询
     * @param start
     * @param end
     * @return
     */
    List<BasicinfoLoginLogDTO> search(Date start, Date end);

    /**
     * 获取所有登录日志
     * @return
     */
    List<BasicinfoLoginLogDTO> open();
}
