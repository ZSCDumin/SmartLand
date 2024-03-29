package com.guotu.gt.mapper;

import com.guotu.gt.domain.BasicinfoActionLog;
import com.guotu.gt.dto.BasicinfoActionLogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 操作日志信息接口
 *
 * @author YalandHong
 */

@Mapper
@Component
public interface BasicinfoActionLogMapper {

    /**
     * 查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 操作记录列表
     */
    List<BasicinfoActionLogDTO> selectByPeriod(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

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
     * 根据编码查询操作人的用户名
     * @param code 操作编码
     * @return 操作信息
     */
    String selectNameByCode(Integer code);

    /**
     * 查询所有操作
     * @return 操作记录列表
     */
    List<BasicinfoActionLogDTO> selectAll();

    /**
     * 插入新的操作日志信息
     * @param basicinfoActionLog 操作日志信息
     */
    void insert(BasicinfoActionLog basicinfoActionLog);

}
