package com.hscy.api.annotation;

import java.lang.annotation.*;

/**
 * Author: yongfa
 * Date: 2019/10/16 14:44
 * Desc: 登录校验
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
