package com.hscy.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hscy.api.entity.UserEntity;
import com.hscy.api.form.LoginForm;

import java.util.Map;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:36
 * Desc: 用户
 */
public interface UserService extends IService<UserEntity> {

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     * @param form    登录表单
     * @return        返回登录信息
     */
    Map<String, Object> login(LoginForm form);
}
