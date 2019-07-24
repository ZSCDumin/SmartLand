package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * PermissionRoleMapper
 * 角色信息接口
 *
 * @author YalandHong
 *
 */
@Mapper
@Component
public interface PermissionRoleMapper {

    /**
     * 根据编码查询
     * @param code 角色编码
     */
    PermissionRole selectByCode(Byte code);

    /**
     * 插入角色信息
     * @param permissionRole 角色信息
     */
    void insert(PermissionRole permissionRole);

    /**
     * 根据编码删除
     * @param code 角色编码
     */
    void deleteByCode(Byte code);

    /**
     * 根据编码更新
     * @param permissionRole 角色信息
     */
    void updateByCode(PermissionRole permissionRole);
}