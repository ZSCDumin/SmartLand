package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUser;
import com.guotu.gt.mapper.PermissionUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPermissionUserService {

    // Test: Permission User
    @Autowired
    PermissionUserMapper permissionUserMapper;
    public PermissionUser puSelect(String code) {
        return permissionUserMapper.selectByCode(code);
    }
    public void puInsert(PermissionUser permissionUser) {
        permissionUserMapper.insert(permissionUser);
    }
    public void puUpdate(PermissionUser permissionUser) {
        permissionUserMapper.updateByCode(permissionUser);
    }
    public void puDelete(String code) {
        permissionUserMapper.deleteByCode(code);
    }



}
