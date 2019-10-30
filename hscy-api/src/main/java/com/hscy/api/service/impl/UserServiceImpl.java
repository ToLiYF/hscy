package com.hscy.api.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hscy.api.dao.UserDao;
import com.hscy.api.entity.TokenEntity;
import com.hscy.api.entity.UserEntity;
import com.hscy.api.form.LoginForm;
import com.hscy.api.service.TokenService;
import com.hscy.api.service.UserService;
import com.hscy.common.exception.CustomException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hscy.common.validator.Assert;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:42
 * Desc:
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    private TokenService tokenService;

    @Override
    public UserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
    }

    @Override
    public Map<String, Object> login(LoginForm form) {
        UserEntity user = queryByMobile(form.getMobile());
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
            throw new CustomException("手机号或密码错误");
        }

        //获取登录token
        TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

        Map<String, Object> map = new HashMap<>(2);
        map.put("token", tokenEntity.getToken());
        map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

        return map;
    }
}
