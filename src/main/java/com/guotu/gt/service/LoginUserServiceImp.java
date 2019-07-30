package com.guotu.gt.service;

import com.guotu.gt.dto.LoginUserDTO;
import com.guotu.gt.mapper.PermissionUserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImp {

    /**
     * 登录，返回用户信息
     * @param userName 用户名
     * @param userPassword 密码
     * @return 用户及角色基本信息， 如果登录失败则返回NULL
     */
    // TODO user DTO mapper findByName()
    // TODO user DTO xml findByName
    // TODO user log in service
    public LoginUserDTO login(String userName, String userPassword) {
        return null;
    }


    @Autowired
    private PermissionUserDTOMapper permissionUserDTOMapper;
}
