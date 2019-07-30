package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionOperation;

import java.util.List;

public interface PermissionOperationService {

    /**
     * 增加一个操作信息
     * @param permissionOperation
     * @return
     */
    PermissionOperation add(com.guotu.gt.domain.PermissionOperation permissionOperation);

    /**
     * 更新一个操作信息
     * @param permissionOperation
     * @return
     */
    PermissionOperation update(com.guotu.gt.domain.PermissionOperation permissionOperation);

    /**
     * 根据code删除一个操作信息
     * @param code
     */
    void delete(int code);

    /**
     * 根据code查找操作信息
     * @param code
     * @return
     */
    com.guotu.gt.domain.PermissionOperation findByCode(int code);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionOperation> findAll();
}
