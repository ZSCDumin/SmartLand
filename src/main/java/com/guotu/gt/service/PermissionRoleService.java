package com.guotu.gt.service;

import com.guotu.gt.dto.PageBean;
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
     * 分页查询所有角色
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 指定页面的角色信息
     */
    PageBean<PermissionRoleDTO> selectAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 获取所有角色的姓名
     * @return 角色姓名列表
     */
    List<String> selectAllRoleName();

    /**
     * 根据编码查找角色
     * @param code 角色编码
     * @return 角色信息
     */
    PermissionRoleDTO selectByCode(Integer code);

    /**
     * 根据角色姓名查找角色信息
     * @param name 角色名
     * @return 角色信息
     */
    PermissionRoleDTO selectByName(String name);

    /**
     * 根据编码更新角色信息
     * @param permissionRoleDTO 新的角色信息
     * @return 旧的角色信息
     */
    PermissionRoleDTO updateByCode(PermissionRoleDTO permissionRoleDTO);

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
     * @return 删除的角色信息实体
     */
    PermissionRoleDTO deleteByCode(Integer code);

}
