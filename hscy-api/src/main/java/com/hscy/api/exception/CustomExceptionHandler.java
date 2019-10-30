package com.hscy.api.exception;


import com.hscy.common.exception.CustomException;
import com.hscy.common.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author: yongfa
 * Date: 2019/10/16 15:24
 * Desc: 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ResultMap handleCustomException(CustomException e){
        ResultMap r = new ResultMap();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultMap handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return ResultMap.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public ResultMap handleException(Exception e){
        log.error(e.getMessage(), e);
        return ResultMap.error();
    }
}
