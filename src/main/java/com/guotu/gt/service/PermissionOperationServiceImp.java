package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionOperation;
import com.guotu.gt.mapper.PermissionOperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionOperationServiceImp implements PermissionOperationService{
    
    @Autowired
    PermissionOperationMapper permissionOperationMapper;

    @Override
    public PermissionOperation add(PermissionOperation permissionOperation){
        return permissionOperationMapper.add(permissionOperation);
    }

    @Override
    public PermissionOperation update(PermissionOperation permissionOperation){
        return permissionOperationMapper.update(permissionOperation);
    }

    @Override
    public void delete(int code){
        permissionOperationMapper.delete(code);
    }

    @Override
    public PermissionOperation findByCode(int code){
        return permissionOperationMapper.findByCode(code);
    }

    @Override
    public List<PermissionOperation> findAll(){
        return permissionOperationMapper.findAll();
    }
}
