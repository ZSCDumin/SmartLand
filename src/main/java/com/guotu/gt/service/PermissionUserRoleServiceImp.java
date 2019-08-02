package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUserRole;
import com.guotu.gt.mapper.PermissionUserRoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionUserRoleServiceImp implements PermissionUserRoleService{
    @Autowired
    PermissionUserRoleMapper permissionUserRoleMapper;

    /**
     * 将指定角色的用户替换为另一种用户编码
     * @param oldRoleCode 旧角色
     * @param newRoleCode 新角色
     */
    @Override
    public void updateRoleCodeToNew(@Param("oldRoleCode") Integer oldRoleCode, @Param("newRoleCode") Integer newRoleCode){
        permissionUserRoleMapper.updateRoleCodeToNew(oldRoleCode,newRoleCode);
    }

    /**
     * 根据用户编码返回用户角色信息实体
     * @param userCode 用户编码
     * @return 用户角色信息实体
     */
    @Override
    public PermissionUserRole findDomainByUserCode(Integer userCode){
        return permissionUserRoleMapper.findDomainByUserCode(userCode);
    }

    /**
     * 根据用户编码删除
     * @param userCode 用户编码
     */
    @Override
    public void deleteByUserCode(Integer userCode){
        permissionUserRoleMapper.deleteByUserCode(userCode);
    }

    /**
     * 插入用户编码和角色编码
     * @param permissionUserRole 用户角色分配信息，包含用户编码和角色编码
     */
    @Override
    public void insertDomain(PermissionUserRole permissionUserRole){
        permissionUserRoleMapper.insertDomain(permissionUserRole);
    }
    /**
     * 插入用户编码和角色名称
     * @param userCode 用户编码
     * @param roleName 角色名称
     */
    public void insertCodeName(Integer userCode, String roleName){
        permissionUserRoleMapper.insertCodeName(userCode,roleName);
    }

    public void updateCodeName(Integer userCode, String roleName){
        permissionUserRoleMapper.updateCodeName(userCode,roleName);
    }
}
