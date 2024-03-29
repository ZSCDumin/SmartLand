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
     * 返回的结果按照编码从小到大排序
     * @return 角色信息列表
     */
    List<PermissionRoleDTO> selectAll();

    /**
     * 获取所有角色的姓名
     * @return 角色姓名列表
     */
    List<String> selectAllRoleName();

    /**
     * 按角色名查询角色信息
     * @param name 角色名
     * @return 指定名字的角色
     */
    PermissionRoleDTO selectByName(String name);

    /**
     * 根据编码查询
     * @param code 角色编码
     */
    PermissionRoleDTO selectByCode(Integer code);

    /**
     * 插入角色信息
     * @param permissionRoleDTO 角色信息
     */
    void insert(PermissionRoleDTO permissionRoleDTO);

    /**
     * 根据编码获取角色实体
     * @param code 角色编码
     * @return 角色实体
     */
    PermissionRole selectDomainByCode(Integer code);

    /**
     * 根据编码删除角色
     * @param code 角色编码
     */
    void deleteByCode(Integer code);

    /**
     * 根据编码更新
     * @param permissionRoleDTO 角色信息
     */
    void updateByCode(PermissionRoleDTO permissionRoleDTO);
}