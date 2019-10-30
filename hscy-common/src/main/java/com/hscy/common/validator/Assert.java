package com.hscy.common.validator;

import com.hscy.common.exception.CustomException;
import org.apache.commons.lang.StringUtils;

/**
 * Author: yongfa
 * Date: 2019/10/15 18:23
 * Desc: 数据校验
 */
public abstract class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CustomException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new CustomException(message);
        }
    }
}
