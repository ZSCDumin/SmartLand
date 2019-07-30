package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionMenu1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMenu1Mapper {

    /**
     * 增加一个机构信息
     * @param permissionMenu1
     * @return
     */
    PermissionMenu1 add(PermissionMenu1 permissionMenu1);

    /**
     * 更新一个机构信息
     * @param permissionMenu1
     * @return
     */
    PermissionMenu1 update(PermissionMenu1 permissionMenu1);

    /**
     * 根据code删除一个一级菜单信息
     * @param code
     */
    void delete(int code);

    /**
     * 根据code查找一级菜单信息
     * @param code
     * @return
     */
    PermissionMenu1 findByCode(int code);

    /**
     * 查询所有一级菜单信息
     * @return
     */
    List<PermissionMenu1> findAll();
}
