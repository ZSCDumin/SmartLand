package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu2Operation;

import java.util.List;

public interface PermissionMenu2OperationService {

    /**
     * 增加一个菜单操作分配信息
     * @param permissionMenu2Operation
     * @return
     */
    PermissionMenu2Operation add(PermissionMenu2Operation permissionMenu2Operation);

    /**
     * 更新一个操作信息
     * @param permissionMenu2Operation
     * @return
     */
    PermissionMenu2Operation update(PermissionMenu2Operation permissionMenu2Operation);

    /**
     * 根据code删除一个操作信息
     * @param code
     */
    void delete(Byte code);

    /**
     * 根据code查找操作信息
     * @param code
     * @return
     */
    PermissionMenu2Operation findByCode(Byte code);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionMenu2Operation> findAll();
}
