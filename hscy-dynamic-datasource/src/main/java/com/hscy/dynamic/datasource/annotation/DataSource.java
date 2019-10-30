package com.hscy.dynamic.datasource.annotation;

import java.lang.annotation.*;

/**
 * Author: yongfa
 * Date: 2019/10/16 16:14
 * Desc: 多数据源注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
