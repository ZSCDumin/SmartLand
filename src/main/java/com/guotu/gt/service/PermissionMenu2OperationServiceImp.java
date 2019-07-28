package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu2Operation;
import com.guotu.gt.mapper.PermissionMenu2OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionMenu2OperationServiceImp implements PermissionMenu2OperationService {
    @Autowired
    PermissionMenu2OperationMapper permissionMenu2OperationMapper;

    @Override
    public PermissionMenu2Operation add(PermissionMenu2Operation permissionMenu2Operation){
        return permissionMenu2OperationMapper.add(permissionMenu2Operation);
    }

    @Override
    public PermissionMenu2Operation update(PermissionMenu2Operation permissionMeu2){
        return permissionMenu2OperationMapper.update(permissionMeu2);
    }

    @Override
    public void delete(Byte code){
        permissionMenu2OperationMapper.delete(code);
    }

    @Override
    public PermissionMenu2Operation findByCode(Byte code){
        return permissionMenu2OperationMapper.findByCode(code);
    }

    @Override
    public List<PermissionMenu2Operation> findAll(){
        return permissionMenu2OperationMapper.findAll();
    }
}
