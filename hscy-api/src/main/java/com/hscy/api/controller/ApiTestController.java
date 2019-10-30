package com.hscy.api.controller;

import com.hscy.api.annotation.Login;
import com.hscy.api.annotation.LoginUser;
import com.hscy.api.entity.UserEntity;
import com.hscy.common.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:45
 * Desc: 测试接口
 */
@RestController
@RequestMapping("/api")
@Api(tags="测试接口")
public class ApiTestController {
    @Login
    @GetMapping("userInfo")
    @ApiOperation(value="获取用户信息", response= UserEntity.class)
    public ResultMap userInfo(@ApiIgnore @LoginUser UserEntity user){
        return ResultMap.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public ResultMap userInfo(@ApiIgnore @RequestAttribute("userId") Integer userId){
        return ResultMap.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public ResultMap notToken(){
        return ResultMap.ok().put("msg", "无需token也能访问。。。");
    }
}
