package com.guotu.gt.service;

import com.github.pagehelper.PageHelper;
import com.guotu.gt.domain.BasicinfoActionLog;
import com.guotu.gt.dto.BasicinfoActionLogDTO;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.mapper.BasicinfoActionLogMapper;
import com.guotu.gt.mapper.PermissionUserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 操作日志管理 - 服务层实现
 *
 * 使用了一些过期的Date操作函数，图个方便
 *
 * @author YalandHong
 */

@Service
public class BasicinfoActionLogServiceImp implements BasicinfoActionLogService {

    /**
     * 查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 操作记录列表
     */
    @Override
    @SuppressWarnings("deprecation")
    public List<BasicinfoActionLogDTO> selectByPeriod(Date startTime, Date endTime) {

        startTime.setHours(0);
        startTime.setMinutes(0);
        startTime.setSeconds(0);
        endTime.setHours(23);
        endTime.setMinutes(59);
        endTime.setSeconds(59);

        //System.out.println(startTime.toString());
        //System.out.println(endTime.toString());

        // 检查日期是否合法 okay
        Assert.isTrue(endTime.after(startTime), "结束时间必须等于或晚于开始时间");

        return basicinfoActionLogMapper.selectByPeriod(startTime, endTime);
    }

    /**
     * 分页查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 指定页面的操作日志
     */
    @Override
    @SuppressWarnings("deprecation")
    public PageBean<BasicinfoActionLogDTO> selectByPeriodByPage(Date startTime, Date endTime,
                                                                Integer pageNum, Integer pageSize) {
        startTime.setHours(0);
        startTime.setMinutes(0);
        startTime.setSeconds(0);
        endTime.setHours(23);
        endTime.setMinutes(59);
        endTime.setSeconds(59);

        // 检查日期是否合法 okay
        Assert.isTrue(endTime.after(startTime), "结束时间必须等于或晚于开始时间");

        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(basicinfoActionLogMapper.selectByPeriod(startTime, endTime));
    }

    /**
     * 根据编码删除操作
     * @param code 操作编码
     */
    @Override
    public void deleteByCode(Integer code) {
        // 判断指定操作是否存在 okay
        Assert.notNull(basicinfoActionLogMapper.selectNameByCode(code),
                "不存在编码为" + code + "的操作日志条目");

        basicinfoActionLogMapper.deleteByCode(code);
    }

    /**
     * 根据用户编码删除操作日志
     * @param userCode 用户编码
     */
    @Override
    public void deleteByUserCode(Integer userCode) {
        basicinfoActionLogMapper.deleteByUserCode(userCode);
    }

    /**
     * 查询所有操作
     * @return 操作记录列表
     */
    @Override
    public List<BasicinfoActionLogDTO> selectAll() {
        return basicinfoActionLogMapper.selectAll();
    }

    /**
     * 分页查询所有操作
     * @return 指定页面的操作记录列表
     */
    @Override
    public PageBean<BasicinfoActionLogDTO> selectAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(basicinfoActionLogMapper.selectAll());
    }

    /**
     * 新增一个操作日志
     * @param userCode 操作用户的编码
     * @param optObject 操作对象
     * @param optType 操作类型
     * @param dataDescription 操作数据
     */
    @Override
    public void insert(Integer userCode, String optObject, String optType, String dataDescription) {
        // 判断指定的用户编码是否存在
        Assert.notNull(permissionUserDTOMapper.findByCode(userCode),
                "日志插入失败：不存在编码为" + userCode + "的用户");
        // 插入操作日志
        basicinfoActionLogMapper.insert(
                new BasicinfoActionLog(null, userCode, optObject, optType, dataDescription, new Date()));
    }

    @Autowired
    private BasicinfoActionLogMapper basicinfoActionLogMapper;

    @Autowired
    private PermissionUserDTOMapper permissionUserDTOMapper;
}
