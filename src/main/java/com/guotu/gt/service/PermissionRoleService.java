package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionRoleDTO;

import java.util.List;

/**
 * 角色管理界面 - 服务接口
 *
 * @author YalandHong
 */

public interface PermissionRoleService {

    /**
     * 查询所有角色
     * @return 角色信息列表
     */
    List<PermissionRoleDTO> selectAll();

    /**
     * 根据编码更新角色信息
     * @param permissionRoleDTO 新的角色信息
     */
    void updateByCode(PermissionRoleDTO permissionRoleDTO);

    /**
     * 新增角色信息
     * @param name 角色名
     * @param description 角色描述
     * @return 新角色的信息
     */
    PermissionRoleDTO insert(String name, String description);

    /**
     * 根据编码删除角色
     * @param code 角色编码
     */
    void deleteByCode(Integer code);

}
