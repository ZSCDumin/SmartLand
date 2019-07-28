package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.mapper.PermissionRoleMenu2OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPermissionRoleMenu2OperationMapperService {

    // Test: PermissionRoleMenu2Operation
    @Autowired
    PermissionRoleMenu2OperationMapper permissionrolemenu2operationMapper;
    public PermissionRoleMenu2Operation prmoSelect(Byte roleCode) {
        return permissionrolemenu2operationMapper.selectByRoleCode(roleCode);
    }
    public void prmoInsert(PermissionRoleMenu2Operation permissionrolemenu2operation) {
        permissionrolemenu2operationMapper.insert(permissionrolemenu2operation);
    }
    public void prmoUpdate(PermissionRoleMenu2Operation permissionrolemenu2operation) {
        permissionrolemenu2operationMapper.updateByRoleCode(permissionrolemenu2operation);
    }
    public void prmoDelete(Byte roleCode) {
        permissionrolemenu2operationMapper.deleteByRoleCode(roleCode);
    }
}
