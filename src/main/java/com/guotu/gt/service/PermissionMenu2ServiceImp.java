package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu2;
import com.guotu.gt.mapper.PermissionMenu2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionMenu2ServiceImp implements PermissionMenu2Service {
    @Autowired
    private PermissionMenu2Mapper permissionMenu2Mapper;

    @Override
    public PermissionMenu2 add(PermissionMenu2 permissionMenu2){
        return permissionMenu2Mapper.add(permissionMenu2);
    }

    @Override
    public PermissionMenu2 update(PermissionMenu2 permissionMeu2){
        return permissionMenu2Mapper.update(permissionMeu2);
    }

    @Override
    public void delete(int code){
        permissionMenu2Mapper.delete(code);
    }

    @Override
    public PermissionMenu2 findByCode(int code){
        return permissionMenu2Mapper.findByCode(code);
    }

    @Override
    public List<PermissionMenu2> findAll(){
        return permissionMenu2Mapper.findAll();
    }

}
