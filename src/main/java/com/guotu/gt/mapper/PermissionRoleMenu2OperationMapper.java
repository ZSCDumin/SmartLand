package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * PermissionRoleMenu2OperationMapper
 * 角色权限分配接口
 *
 * @author YalandHong
 *
 */

@Mapper
@Component
public interface PermissionRoleMenu2OperationMapper {

    /**
     * 根据编码查询
     * @param roleCode 角色编码
     */
    PermissionRoleMenu2Operation selectByRoleCode(Byte roleCode);

    /**
     * 根据编码删除
     * @param roleCode 角色编码
     */
    void deleteByRoleCode(Byte roleCode);

    /**
     * 根据编码更新
     * @param permissionRoleMenu2Operation 角色权限分配信息
     */
    void updateByRoleCode(PermissionRoleMenu2Operation permissionRoleMenu2Operation);

    /**
     * 插入角色权限分配信息
     * @param permissionRoleMenu2Operation 角色权限分配信息
     */
    void insert(PermissionRoleMenu2Operation permissionRoleMenu2Operation);
}
