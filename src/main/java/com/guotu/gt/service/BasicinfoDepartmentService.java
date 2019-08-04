package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoDepartment;
import com.guotu.gt.dto.BasicinfoDepartmentDTO;

import java.util.List;

public interface BasicinfoDepartmentService {

    /**
     * 增加一个机构信息
     * @param basicinfoDepartment
     * @return
     */
    void add(BasicinfoDepartment basicinfoDepartment);

    /**
     * 更新一个机构信息
     * @param basicinfoDepartment
     * @return
     */
    void update(BasicinfoDepartment basicinfoDepartment);

    /**
     * 根据code删除机构信息
     * @param code
     */
    void delete(int code);

    /**
     * 根据code查找
     * @param code
     * @return
     */
    BasicinfoDepartmentDTO findByCode(int code);

    /**
     * 查找所有
     * @return
     */
    List<BasicinfoDepartmentDTO> findAll();

}
