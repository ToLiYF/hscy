package com.hscy.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hscy.api.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:38
 * Desc: 用户
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
}
