package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionUserDTO;
import com.guotu.gt.mapper.PermissionUserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionUserDTOServiceImp implements PermissionUserDTOService{
    
    @Autowired
    PermissionUserDTOMapper permissionUserDTOMapper;

    @Override
    public PermissionUserDTO add(PermissionUserDTO permissionUserDTO){
        return permissionUserDTOMapper.add(permissionUserDTO);
    }

    @Override
    public void update(PermissionUserDTO permissionUserDTO){
        permissionUserDTOMapper.update(permissionUserDTO);
    }

    @Override
    public void delete(String name){
        permissionUserDTOMapper.delete(name);
    }

    @Override
    public List<PermissionUserDTO> findAll(){
        return permissionUserDTOMapper.findAll();
    }
}
