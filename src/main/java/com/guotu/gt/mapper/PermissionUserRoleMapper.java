package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PermissionUserRoleMapper {

    /**
     * 根据用户编码选择角色分配信息
     * @param userCode 用户编码
     * @return 用户角色分配信息
     */
    PermissionUserRole selectByUserCode(String userCode);

    /**
     * 插入用户角色分配信息
     * @param permissionUserRole 用户角色分配信息
     */
    void insert(PermissionUserRole permissionUserRole);

    /**
     * 根据用户编码更新
     * @param permissionUserRole 用户角色分配信息
     */
    void updateByUserCode(PermissionUserRole permissionUserRole);

    /**
     * 根据用户编码删除
     * @param userCode 用户编码
     */
    void deleteByUserCode(String userCode);
}