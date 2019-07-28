package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionModel;

import java.util.List;

public interface PermissionModelService {

    /**
     * 增加一个机构信息
     * @param permissionModel
     * @return
     */
    PermissionModel add(PermissionModel permissionModel);

    /**
     * 更新一个机构信息
     * @param permissionModel
     * @return
     */
    PermissionModel update(PermissionModel permissionModel);

    /**
     * 根据code删除一个机构信息
     * @param code
     */
    void delete(Byte code);

    /**
     * 根据code查找机构信息
     * @param code
     * @return
     */
    PermissionModel findByCode(Byte code);

    /**
     * 查询所有机构信息
     * @return
     */
    List<PermissionModel> findAll();
}
