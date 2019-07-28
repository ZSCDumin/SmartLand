package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionModelMapper {
    /**
     * 增加一个模块信息
     * @param permissionModel
     * @return
     */
    PermissionModel add(PermissionModel permissionModel);

    /**
     * 更新一个模块信息
     * @param permissionModel
     * @return
     */
    PermissionModel update(PermissionModel permissionModel);

    /**
     * 根据code删除一个模块信息
     * @param code
     */
    void delete(Byte code);

    /**
     * 根据code查找模块信息
     * @param code
     * @return
     */
    PermissionModel findByCode(Byte code);

    /**
     * 查询所有模块信息
     * @return
     */
    List<PermissionModel> findAll();
}
