package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionRole;
import com.guotu.gt.dto.PermissionRoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * 查询所有角色
     * @return 角色信息列表
     */
    List<PermissionRoleDTO> selectAll();

    /**
     * 按角色名查询角色信息
     * @param name 角色名
     * @return 指定名字的角色
     */
    PermissionRoleDTO selectByName(String name);

    /**
     * 插入角色信息
     * @param permissionRole 角色信息
     */
    void insert(PermissionRole permissionRole);

    /**
     * 根据编码获取标志位
     * @param code 角色编码
     * @return 角色标志位
     */
    Byte selectFlagByCode(Byte code);

    /**
     * 根据编码删除角色
     * @param code 角色编码
     */
    void deleteByCode(Byte code);

    /**
     * 根据编码查询
     * @param code 角色编码
     */
    PermissionRole selectByCode(Byte code);

    /**
     * 根据编码更新
     * @param permissionRole 角色信息
     */
    void updateByCode(PermissionRole permissionRole);
}