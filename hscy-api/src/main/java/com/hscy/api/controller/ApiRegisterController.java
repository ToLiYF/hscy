package com.hscy.api.controller;

import com.hscy.api.annotation.Login;
import com.hscy.api.form.LoginForm;
import com.hscy.api.service.TokenService;
import com.hscy.api.service.UserService;
import com.hscy.common.utils.ResultMap;
import com.hscy.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:44
 * Desc: 注册接口
 */
@RestController
@RequestMapping("/api")
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("login")
    @ApiOperation("登录")
    public ResultMap login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = userService.login(form);

        return ResultMap.ok(map);
    }

    @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public ResultMap logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return ResultMap.ok();
    }
}
