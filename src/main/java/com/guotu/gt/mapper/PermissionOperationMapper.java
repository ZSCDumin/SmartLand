package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionOperation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionOperationMapper {

    /**
     * 增加一个操作信息
     * @param permissionOperation
     * @return
     */
    PermissionOperation add(PermissionOperation permissionOperation);

    /**
     * 更新一个操作信息
     * @param permissionOperation
     * @return
     */
    PermissionOperation update(PermissionOperation permissionOperation);

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
    PermissionOperation findByCode(Byte code);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionOperation> findAll();
}
