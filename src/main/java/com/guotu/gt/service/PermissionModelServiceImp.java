package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionModel;
import com.guotu.gt.mapper.PermissionModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionModelServiceImp implements PermissionModelService {
    @Autowired
    private PermissionModelMapper permissionModelMapper;

    @Override
    public PermissionModel add(PermissionModel permissionModel){
        return permissionModelMapper.add(permissionModel);
    }

    @Override
    public PermissionModel update(PermissionModel permissionModel){
        return permissionModelMapper.update(permissionModel);
    }

    @Override
    public void delete(int code){
        permissionModelMapper.delete(code);
    }

    @Override
    public PermissionModel findByCode(int code){
        return permissionModelMapper.findByCode(code);
    }

    @Override
    public List<PermissionModel> findAll(){
        return permissionModelMapper.findAll();
    }
}
