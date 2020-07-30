package com.share.validation.constraintvalidators;


import cn.hutool.core.util.ArrayUtil;
import com.share.validation.constraints.CollectionStringConstraint;
import com.share.validation.MyConstraintUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 集合校验的校验器
 * 校验字段的值必须在指定的集合范围内
 *
 * @author guozhe
 * @date 2020/07/30
 */
public class CollectionStringValidator implements ConstraintValidator<CollectionStringConstraint, String> {

    /**
     * 取值范围
     */
    String[] valueRange;

    @Override
    public void initialize(CollectionStringConstraint constraintAnnotation) {
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
