package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUserRole;

public interface PermissionUserRoleService {

    /**
     * 将指定角色的用户替换为另一种用户编码
     * @param oldRoleCode 旧角色
     * @param newRoleCode 新角色
     */
    void updateRoleCodeToNew( Integer oldRoleCode, Integer newRoleCode);

    /**
     * 根据用户编码返回用户角色信息实体
     * @param userCode 用户编码
     * @return 用户角色信息实体
     */
    PermissionUserRole findDomainByUserCode(Integer userCode);

    /**
     * 根据用户编码删除
     * @param userCode 用户编码
     */
    void deleteByUserCode(Integer userCode);

    /**
     * 插入用户编码和角色编码
     * @param permissionUserRole 用户角色分配信息，包含用户编码和角色编码
     */
    void insertDomain(PermissionUserRole permissionUserRole);

    /**
     * 插入用户编码和角色名称
     * @param userCode 用户编码
     * @param roleName 角色名称
     */
    void insertCodeName(Integer userCode, String roleName);

    void updateCodeName(Integer userCode, String roleName);
}
