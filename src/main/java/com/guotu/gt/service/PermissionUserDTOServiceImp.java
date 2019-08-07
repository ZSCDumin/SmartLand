package com.guotu.gt.service;

import com.github.pagehelper.PageHelper;
import com.guotu.gt.dto.PageBean;
import com.guotu.gt.dto.PermissionUserDTO;
import com.guotu.gt.mapper.PermissionUserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PermissionUserDTOServiceImp implements PermissionUserDTOService{
    
    @Autowired
    PermissionUserDTOMapper permissionUserDTOMapper;

    @Override
    public void add(PermissionUserDTO permissionUserDTO){
        permissionUserDTOMapper.add(permissionUserDTO);
    }

    @Override
    public void update(PermissionUserDTO permissionUserDTO){
        permissionUserDTOMapper.update(permissionUserDTO);
    }

    @Override
    public void delete(int code){
        permissionUserDTOMapper.delete(code);
    }

    @Override
    public List<PermissionUserDTO> findAll() {
        return permissionUserDTOMapper.findAll();
    }

    /**
     * 分页查找用户信息
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 指定页码的用户信息
     */
    @Override
    public PageBean<PermissionUserDTO> findAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageBean<>(permissionUserDTOMapper.findAll());
    }

    @Override
    public PermissionUserDTO findByName(String name){
     return permissionUserDTOMapper.findByName(name);
    }

    @Override
    public PermissionUserDTO findByCode(int code){
        return permissionUserDTOMapper.findByCode(code);
    }
}
