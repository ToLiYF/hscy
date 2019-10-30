package com.hscy.common.aspect;

import com.hscy.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: yongfa
 * Date: 2019/10/15 17:47
 * Desc:
 */
@Aspect
@Slf4j
@Component
public class RedisAspect {

    /**
     * 是否开启redis缓存  true开启   false关闭
     */
    @Value("${renren.redis.open: false}")
    private boolean open;

    @Around("execution(* com.hscy.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception e){
                log.error("redis error", e);
                throw new CustomException("Redis服务异常");
            }
        }
        return result;
    }
}
