package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionUserRole;
import com.guotu.gt.dto.LoginUserDTO;
import com.guotu.gt.dto.PermissionUserDTO;
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
     * 用户登录，并返回用户信息
     * @param userName 用户名
     * @param password 密码
     * @param ipAddress IP地址
     * @param machineName 机器名
     * @return 用户信息
     */
    @Override
    public LoginUserDTO login(String userName, String password, String ipAddress, String machineName) {
        // 判断参数合法性
        Assert.isTrue(ipAddress != null && ipAddress.trim().length()>0, "IP地址不能为空");

        // 根据用户名查询用户信息
        PermissionUserDTO permissionUserDTO = permissionUserDTOMapper.findByName(userName);
        Assert.isTrue(permissionUserDTO != null
                        && permissionUserDTO.getPassword().equals(password),
                "用户名或密码错误");  // 用户名不存在或者密码错误 okay

        // 获取用户的角色 okay
        PermissionUserRole permissionUserRole = permissionUserRoleMapper.findDomainByUserCode(permissionUserDTO.getCode());
        Assert.notNull(permissionUserRole, "用户\"" + permissionUserDTO.getName() + "\"未分配角色");

        LoginUserDTO loginUserDTO = new LoginUserDTO(permissionUserDTO.getCode(),  // 返回用户编码
                userName,   // 返回用户名
                permissionUserRole.getRoleCode());  // 返回角色编码
        // TODO 获取权限信息

        // 记录登录日志
        basicinfoLoginLogDTOService.insert(loginUserDTO.getUserCode(), ipAddress, machineName);

        return loginUserDTO;
    }


    @Autowired
    private PermissionUserDTOMapper permissionUserDTOMapper;

    @Autowired
    private PermissionUserRoleMapper permissionUserRoleMapper;

    @Autowired
    private BasicinfoLoginLogDTOService basicinfoLoginLogDTOService;
}
