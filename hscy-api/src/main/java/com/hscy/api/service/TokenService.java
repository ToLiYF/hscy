package com.hscy.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hscy.api.entity.TokenEntity;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:35
 * Desc: 用户Token
 */
public interface TokenService extends IService<TokenEntity> {

    TokenEntity queryByToken(String token);

    /**
     * 生成token
     * @param userId  用户ID
     * @return        返回token信息
     */
    TokenEntity createToken(long userId);

    /**
     * 设置token过期
     * @param userId 用户ID
     */
    void expireToken(long userId);
}
