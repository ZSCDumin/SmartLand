package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionUserDTO;

import java.util.List;


public interface PermissionUserDTOService {

    /**
     * 增加一个操作信息
     * @param permissionUserDTO
     * @return
     */
    void add(PermissionUserDTO permissionUserDTO);

    /**
     * 更新一个操作信息
     * @param permissionUserDTO
     * @return
     */
    void update(PermissionUserDTO permissionUserDTO);

    /**
     * 根据code删除一个操作信息
     * @param code
     */
    void delete(int code);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionUserDTO> findAll();

    /**
     * 根据用户名查找用户信息
     * @param name
     * @return
     */
    PermissionUserDTO findByName(String name);

    /**
     * 根据用户编码查找用户信息DTO
     * @param code
     * @return
     */
    PermissionUserDTO findByCode(int code);
}
