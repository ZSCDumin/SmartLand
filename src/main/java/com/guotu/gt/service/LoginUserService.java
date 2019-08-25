package com.guotu.gt.service;

import com.guotu.gt.dto.LoginUserDTO;

/**
 * 用户登录 - 服务接口
 *
 * @author YalandHong
 */

public interface LoginUserService {

    /**
     * 用户登录，并返回用户信息
     * @param userName 用户名
     * @param password 密码
     * @param ipAddress IP地址
     * @param machineName 机器名
     * @return 用户信息
     */
    LoginUserDTO login(String userName, String password, String ipAddress, String machineName);
}
