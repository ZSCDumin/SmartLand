package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.dto.UserManagementDTO;

import java.util.List;

public interface PermissionRoleMenu2OperationService {

    /**
     * 根据编码删除
     * @param roleCode 角色编码
     */
    void deleteByRoleCode(Integer roleCode);

    /**
     * 批量插入角色权限分配信息
     * @param permissionRoleMenu2OperationList 角色权限分配信息
     */
    void insert(List<PermissionRoleMenu2Operation> permissionRoleMenu2OperationList);

    /**
     * 根据角色编码查找角色权限
     * @param roleCode
     * @return
     */
    List<UserManagementDTO> open(int roleCode);

    /**
     * 分页查找角色权限
     * @param roleCode 角色编码
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 分页权限信息
     */
    PageBean<UserManagementDTO> openByPage(int roleCode, int pageNum, int pageSize);
}
