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

}
