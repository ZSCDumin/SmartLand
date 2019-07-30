package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionUserDTO;

import java.util.List;


public interface PermissionUserDTOService {

    /**
     * 增加一个操作信息
     * @param permissionUserDTO
     * @return
     */
    PermissionUserDTO add(PermissionUserDTO permissionUserDTO);

    /**
     * 更新一个操作信息
     * @param permissionUserDTO
     * @return
     */
    void update(PermissionUserDTO permissionUserDTO);

    /**
     * 根据code删除一个操作信息
     * @param name
     */
    void delete(String name);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionUserDTO> findAll();
}