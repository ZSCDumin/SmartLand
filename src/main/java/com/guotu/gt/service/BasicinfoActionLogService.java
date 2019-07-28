package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoActionLog;
import com.guotu.gt.dto.BasicinfoActionLogDTO;

import java.util.Date;
import java.util.List;

/**
 * 操作日志管理界面 - 服务接口
 *
 * @author YalandHong
 */
public interface BasicinfoActionLogService {

    /**
     * 查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 操作记录列表
     */
    List<BasicinfoActionLogDTO> selectByPeriod(Date startTime, Date endTime);

    /**
     * 根据编码删除操作
     * @param code 操作编码
     */
    void deleteByCode(Byte code);

    // TEST

    /**
     * 根据编码返回操作日志信息
     * @param code 编码
     * @return 操作日志信息
     */
    BasicinfoActionLog selectByCode(Byte code);

    /**
     * 插入新的操作日志信息
     * @param basicinfoActionLog 操作日志信息
     */
    void insert(BasicinfoActionLog basicinfoActionLog);
}
