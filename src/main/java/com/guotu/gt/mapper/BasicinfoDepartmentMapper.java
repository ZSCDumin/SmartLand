package com.guotu.gt.mapper;

import com.guotu.gt.domain.BasicinfoDepartment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicinfoDepartmentMapper {

    /**
     * 增加一个机构信息
     * @param basicinfoDepartment
     * @return
     */
    BasicinfoDepartment add(BasicinfoDepartment basicinfoDepartment);

    /**
     * 更新一个机构信息
     * @param basicinfoDepartment
     * @return
     */
    BasicinfoDepartment update(BasicinfoDepartment basicinfoDepartment);

    /**
     * 根据code删除一个机构信息
     * @param code
     */
    void delete(int code);

    /**
     * 根据code查找机构信息
     * @param code
     * @return
     */
    BasicinfoDepartment findByCode(int code);

    /**
     * 查询所有机构信息
     * @return
     */
    List<BasicinfoDepartment> findAll();
}
