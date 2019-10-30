package com.hscy.common.validator;

import com.hscy.common.exception.CustomException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Author: yongfa
 * Date: 2019/10/15 18:24
 * Desc: hibernate-validator校验工具类
 *       参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws CustomException  校验不通过，则报CustomException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws CustomException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new CustomException(constraint.getMessage());
        }
    }
}
