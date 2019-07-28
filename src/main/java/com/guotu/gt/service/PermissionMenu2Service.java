package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu2;

import java.util.List;

public interface PermissionMenu2Service {

    /**
     * 增加一个机构信息
     * @param permissionMenu2
     * @return
     */
    PermissionMenu2 add(PermissionMenu2 permissionMenu2);

    /**
     * 更新一个机构信息
     * @param permissionMenu2
     * @return
     */
    PermissionMenu2 update(PermissionMenu2 permissionMenu2);

    /**
     * 根据code删除一个一级菜单信息
     * @param code
     */
    void delete(Byte code);

    /**
     * 根据code查找一级菜单信息
     * @param code
     * @return
     */
    PermissionMenu2 findByCode(Byte code);

    /**
     * 查询所有一级菜单信息
     * @return
     */
    List<PermissionMenu2> findAll();
}
