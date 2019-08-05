package com.guotu.gt.mapper;

import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BasicinfoLoginLogDTOMapper {

    /**
     * 根据编码删除选中用户登录信息
     * @param code
     * @return
     */
    BasicinfoLoginLogDTO delete(int code);

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
