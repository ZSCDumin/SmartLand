package com.guotu.gt.service;

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
    void deleteByCode(Integer code);

    /**
     * 查询所有操作
     * @return 操作记录列表
     */
    List<BasicinfoActionLogDTO> selectAll();


    /**
     * 新增一个操作日志
     * @param userCode 操作用户的编码
     * @param optObject 操作对象
     * @param optType 操作类型
     * @param dataDescription 操作数据
     * @param optTime 操作时间
     */
    void insert(Integer userCode, String optObject, String optType, String dataDescription, Date optTime);
}
