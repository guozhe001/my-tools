package com.nicai.validation.constraintvalidators;


import cn.hutool.core.util.ArrayUtil;
import com.nicai.validation.MyConstraintUtil;
import com.nicai.validation.constraints.RangeStringConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 字符串范围约束校验器
 * 校验字段的值必须在指定的集合范围内
 *
 * @author guozhe
 * @date 2020/07/30
 */
public class RangeStringValidator implements ConstraintValidator<RangeStringConstraint, String> {

    /**
     * 取值范围
     */
    String[] valueRange;

    @Override
    public void initialize(RangeStringConstraint constraintAnnotation) {
        this.valueRange = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        // 判断字段的值是否在指定的取值范围之内
        boolean contains = ArrayUtil.contains(valueRange, value);
        if (contains) {
            return true;
        }
        MyConstraintUtil.changeConstraintMessageTemplate(context, valueRange);
        return false;
    }
}
