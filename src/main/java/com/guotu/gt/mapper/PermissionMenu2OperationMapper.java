package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionMenu2Operation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMenu2OperationMapper {

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
    void delete(int code);

    /**
     * 根据code查找操作信息
     * @param code
     * @return
     */
    PermissionMenu2Operation findByCode(int code);

    /**
     * 查询所有操作信息
     * @return
     */
    List<PermissionMenu2Operation> findAll();

    /**
     * 判断指定的菜单操作分配实体是否存在
     * @param permissionMenu2Operation 菜单操作分配实体
     * @return 1表示存在，0表示不存在
     */
    Integer checkExists(PermissionMenu2Operation permissionMenu2Operation);
}
