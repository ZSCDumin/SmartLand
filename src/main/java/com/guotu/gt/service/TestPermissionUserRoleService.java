package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUserRole;
import com.guotu.gt.mapper.PermissionUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPermissionUserRoleService {
    // Test: Permission User Role
    @Autowired
    PermissionUserRoleMapper permissionUserRoleMapper;
    public PermissionUserRole purSelect(String userCode) {
        return permissionUserRoleMapper.selectByUserCode(userCode);
    }
    public void purInsert(PermissionUserRole permissionUserRole) {
        permissionUserRoleMapper.insert(permissionUserRole);
    }
    public void purUpdate(PermissionUserRole permissionUserRole) {
        permissionUserRoleMapper.updateByUserCode(permissionUserRole);
    }
    public void purDelete(String userCode) {
        permissionUserRoleMapper.deleteByUserCode(userCode);
    }
}
