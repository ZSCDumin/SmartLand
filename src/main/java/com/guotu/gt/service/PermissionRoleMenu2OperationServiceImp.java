package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.dto.UserManagementDTO;
import com.guotu.gt.mapper.PermissionRoleMenu2OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionRoleMenu2OperationServiceImp implements PermissionRoleMenu2OperationService{

    @Autowired
    PermissionRoleMenu2OperationMapper permissionRoleMenu2OperationMapper;

    @Override
    public void deleteByRoleCode(Integer roleCode){
        permissionRoleMenu2OperationMapper.deleteByRoleCode(roleCode);
    }

    @Override
    public void insert(List<PermissionRoleMenu2Operation> permissionRoleMenu2OperationList){
        permissionRoleMenu2OperationMapper.insert(permissionRoleMenu2OperationList);
    }

    @Override
    public UserManagementDTO open(int roleCode){
        return permissionRoleMenu2OperationMapper.open(roleCode);
    }

}
