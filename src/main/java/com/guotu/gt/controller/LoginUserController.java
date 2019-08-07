package com.guotu.gt.controller;

import com.guotu.gt.dto.LoginUserDTO;
import com.guotu.gt.dto.LoginUserSigninDTO;
import com.guotu.gt.dto.Result;
import com.guotu.gt.service.LoginUserService;
import com.guotu.gt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 登录界面
 *
 * @author YalandHong
 */

@RestController
@Api(tags = "登录界面")
@RequestMapping("/userlogin")
public class LoginUserController {

    @PostMapping
    @ApiOperation(value = "用户登录接口",
            notes = "输入非空白的用户名和密码，验证成功后返回用户编码、角色权限等信息。"
            + "  \n如果用户名或密码错误，则抛出错误信息。  \n后台会记录用户登录日志。")
    public Result<LoginUserDTO> login(@RequestBody @Valid LoginUserSigninDTO loginUserSigninDTO,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {  // 验证参数合法性
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(loginUserService.login(loginUserSigninDTO));
    }

    @Autowired
    LoginUserService loginUserService;
}
