package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu1;
import com.guotu.gt.mapper.PermissionMenu1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionMenu1ServiceImp implements PermissionMenu1Service{
    @Autowired
    private PermissionMenu1Mapper permissionMenu1Mapper;
    
    @Override
    public PermissionMenu1 add(PermissionMenu1 permissionMenu1){
        return permissionMenu1Mapper.add(permissionMenu1);
    }

    @Override
    public PermissionMenu1 update(PermissionMenu1 permissionMeu1){
        return permissionMenu1Mapper.update(permissionMeu1);
    }

    @Override
    public void delete(int code){
        permissionMenu1Mapper.delete(code);
    }

    @Override
    public PermissionMenu1 findByCode(int code){
        return permissionMenu1Mapper.findByCode(code);
    }

    @Override
    public List<PermissionMenu1> findAll(){
        return permissionMenu1Mapper.findAll();
    }
    
}
