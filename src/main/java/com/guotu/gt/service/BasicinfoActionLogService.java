package com.guotu.gt.service;

import com.guotu.gt.dto.BasicinfoActionLogDTO;
import com.guotu.gt.dto.PageBean;

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
     * 分页查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 指定页面的操作日志
     */
    PageBean<BasicinfoActionLogDTO> selectByPeriodByPage(Date startTime, Date endTime,
                                                         Integer pageNum, Integer pageSize);

    /**
     * 根据编码删除操作
     * @param code 操作编码
     */
    void deleteByCode(Integer code);

    /**
     * 根据用户编码删除操作日志
     * @param userCode 用户编码
     */
    void deleteByUserCode(Integer userCode);

    /**
     * 查询所有操作
     * @return 操作记录列表
     */
    List<BasicinfoActionLogDTO> selectAll();

    /**
     * 分页查询所有操作
     * @return 指定页面的操作记录列表
     */
    PageBean<BasicinfoActionLogDTO> selectAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 新增一个操作日志
     * @param userCode 操作用户的编码
     * @param optObject 操作对象
     * @param optType 操作类型
     * @param dataDescription 操作数据
     */
    void insert(Integer userCode, String optObject, String optType, String dataDescription);

}
