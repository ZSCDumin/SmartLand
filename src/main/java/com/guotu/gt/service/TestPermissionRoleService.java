package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionRole;
import com.guotu.gt.domain.PermissionUser;
import com.guotu.gt.mapper.PermissionRoleMapper;
import com.guotu.gt.mapper.PermissionUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPermissionRoleService {

    // Test: Permission Role
    @Autowired
    PermissionRoleMapper permissionRoleMapper;

    public PermissionRole prSelect(Byte code) {
        return permissionRoleMapper.selectByCode(code);
    }
    public void prInsert(PermissionRole permissionRole) {
        permissionRoleMapper.insert(permissionRole);
    }
    public void prUpdate(PermissionRole permissionRole) {
        permissionRoleMapper.updateByCode(permissionRole);
    }
    public void prDelete(Byte code) {
        permissionRoleMapper.deleteByCode(code);
    }
}
