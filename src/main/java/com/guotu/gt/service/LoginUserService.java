package com.guotu.gt.service;

import com.guotu.gt.dto.LoginUserDTO;

/**
 * 用户登录 - 服务接口
 *
 * @author YalandHong
 */

public interface LoginUserService {

    /**
     * 登录，返回用户信息
     * @param userName 用户名
     * @param userPassword 密码
     * @return 用户及角色基本信息， 如果登录失败则返回NULL
     */
    LoginUserDTO login(String userName, String userPassword);
}
