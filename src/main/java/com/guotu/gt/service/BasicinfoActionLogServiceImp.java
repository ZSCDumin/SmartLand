package com.guotu.gt.service;

import com.guotu.gt.dto.BasicinfoActionLogDTO;
import com.guotu.gt.mapper.BasicinfoActionLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class BasicinfoActionLogServiceImp implements BasicinfoActionLogService {

    /**
     * 查询指定时间段内的操作记录
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 操作记录列表
     */
    @Override
    public List<BasicinfoActionLogDTO> selectByPeriod(Date startTime, Date endTime) {

        // 检查日期是否合法 okay
        Assert.isTrue(endTime.after(startTime), "结束时间必须晚于开始时间");

        return basicinfoActionLogMapper.selectByPeriod(startTime, endTime);
    }

    /**
     * 根据编码删除操作
     * @param code 操作编码
     */
    @Override
    public void deleteByCode(Byte code) {
        // 判断指定操作是否存在 okay
        Assert.notNull(basicinfoActionLogMapper.selectNameByCode(code), "不存在编码为" + code + "操作");

        basicinfoActionLogMapper.deleteByCode(code);
    }

    @Autowired
    private BasicinfoActionLogMapper basicinfoActionLogMapper;
}
