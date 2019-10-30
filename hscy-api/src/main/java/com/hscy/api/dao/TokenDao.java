package com.hscy.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hscy.api.entity.TokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:38
 * Desc: 用户Token
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
}
