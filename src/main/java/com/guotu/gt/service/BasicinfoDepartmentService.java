package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoDepartment;

import java.util.List;

public interface BasicinfoDepartmentService {

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
     * 根据code删除机构信息
     * @param code
     */
    void delete(String code);

    /**
     * 根据code查找
     * @param code
     * @return
     */
    BasicinfoDepartment findByCode(String code);

    /**
     * 查找所有
     * @return
     */
    List<BasicinfoDepartment> findAll();

}
