package com.guotu.gt.service;

import com.guotu.gt.dto.LoginUserDTO;
import com.guotu.gt.dto.LoginUserSigninDTO;

/**
 * 用户登录 - 服务接口
 *
 * @author YalandHong
 */

public interface LoginUserService {

    /**
     * 登录，返回用户信息
     * @param loginUserSigninDTO 登录信息，包括用户名和密码
     * @return 用户及角色基本信息
     */
    LoginUserDTO login(LoginUserSigninDTO loginUserSigninDTO);
}
