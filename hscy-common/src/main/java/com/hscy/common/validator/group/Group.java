package com.hscy.common.validator.group;

import javax.validation.GroupSequence;

/**
 * Author: yongfa
 * Date: 2019/10/15 18:26
 * Desc: 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 */
@GroupSequence({AddGroup.class,UpdateGroup.class})
public interface Group {
}
