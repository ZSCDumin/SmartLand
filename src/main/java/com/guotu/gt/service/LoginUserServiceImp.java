package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUser;
import com.guotu.gt.domain.PermissionUserRole;
import com.guotu.gt.dto.LoginUserDTO;
import com.guotu.gt.dto.LoginUserSigninDTO;
import com.guotu.gt.mapper.PermissionUserDTOMapper;
import com.guotu.gt.mapper.PermissionUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户登录 - 服务实现
 *
 * @author YalandHong
 */

@Service
public class LoginUserServiceImp implements LoginUserService {

    /**
     * 登录，返回用户信息
     * @param loginUserSigninDTO 登录信息，包括用户名和密码
     * @return 用户及角色基本信息
     */
    @Override
    public LoginUserDTO login(LoginUserSigninDTO loginUserSigninDTO) {
        // 根据用户名查询用户信息
        PermissionUser permissionUser = permissionUserDTOMapper.findDomainByName(loginUserSigninDTO.getUserName());
        Assert.isTrue(permissionUser != null
                        && permissionUser.getPassword().equals(loginUserSigninDTO.getPassword()),
                "用户名或密码错误");  // 用户名不存在或者密码错误 okay

        // 获取用户的角色 okay
        PermissionUserRole permissionUserRole = permissionUserRoleMapper.findDomainByUserCode(permissionUser.getCode());
        Assert.notNull(permissionUserRole, "用户\"" + permissionUser.getName() + "\"未分配角色");

        return new LoginUserDTO(permissionUser.getCode(),  // 返回用户编码
                loginUserSigninDTO.getUserName(),   // 返回用户名
                permissionUserRole.getRoleCode());  // 返回角色编码
        // TODO 获取权限信息
    }


    @Autowired
    private PermissionUserDTOMapper permissionUserDTOMapper;

    @Autowired
    private PermissionUserRoleMapper permissionUserRoleMapper;
}
