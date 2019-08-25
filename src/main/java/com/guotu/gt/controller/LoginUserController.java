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

import javax.servlet.http.HttpServletRequest;
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
                                      BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {  // 验证参数合法性
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        // 设置HTTP请求编码格式为UTF-8
        try {
            httpServletRequest.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            throw new Exception("服务器不支持UTF-8的格式编码");
        }

        return ResultUtil.success(loginUserService.login(loginUserSigninDTO.getUserName(),
                loginUserSigninDTO.getPassword(),
                getRealAddress(httpServletRequest),
                httpServletRequest.getRemoteHost()));
    }

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private HttpServletRequest httpServletRequest;
	
	/**
	 * 获取IP地址
	 * 
	 * @author hhhh222222
	 */
    private static String getRealAddress(HttpServletRequest request) {
		//X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            // Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        // WL-Proxy-Client-IP：weblogic 服务代理
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        // HTTP_CLIENT_IP：有些代理服务器
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        // X-Real-IP：nginx服务代理
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("X-Real-IP");
        }
		// 可通过http头伪造，和X-Forwarded-For格式类似
		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ipAddresses = request.getHeader("HTTP_X_FORWARDED_FOR");
		}

        String ip = null;
        // 有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            System.out.println("Proxy IP List -> " + ipAddresses);
            ip = ipAddresses.split("[,]")[0];
        }

        // 还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
			System.out.println("Non-proxy IP -> " + ip);
        }
        return ip;
    }
}
