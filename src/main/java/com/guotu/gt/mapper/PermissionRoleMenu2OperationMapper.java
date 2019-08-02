package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.UserManagementDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PermissionRoleMenu2OperationMapper
 * 角色权限分配接口
 *
 * @author YalandHong
 *
 */

@Mapper
@Component
public interface PermissionRoleMenu2OperationMapper {

    /**
     * 根据编码删除
     * @param roleCode 角色编码
     */
    void deleteByRoleCode(Integer roleCode);


    // 测试

    /**
     * 根据编码查询
     * @param roleCode 角色编码
     */
    PermissionRoleMenu2Operation selectByRoleCode(Integer roleCode);

    /**
     * 根据编码更新
     * @param permissionRoleMenu2Operation 角色权限分配信息
     */
    void updateByRoleCode(PermissionRoleMenu2Operation permissionRoleMenu2Operation);

    /**
     * 批量插入角色权限分配信息
     * @param permissionRoleMenu2OperationList 角色权限分配信息
     */
    void insert(List<PermissionRoleMenu2Operation> permissionRoleMenu2OperationList);

    /**
     * 根据角色编码查找角色权限
     * @param roleCode
     * @return
     */
    List<UserManagementDTO> open(int roleCode);
}
