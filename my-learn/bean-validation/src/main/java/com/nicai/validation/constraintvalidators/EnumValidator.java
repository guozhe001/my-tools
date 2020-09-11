package com.nicai.validation.constraintvalidators;

import com.google.common.base.Joiner;
import com.nicai.util.EnumUtil;
import com.nicai.validation.MyConstraintUtil;
import com.nicai.validation.constraints.RangeEnumConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

/**
 * 枚举值校验
 *
 * @author guozhe
 * @date 2017/11/27
 */
public class EnumValidator implements ConstraintValidator<RangeEnumConstraint, String> {
    /**
     * 枚举Class
     */
    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(RangeEnumConstraint constraintAnnotation) {
        this.enumClass = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }

        Set<String> names = EnumUtil.listAllNames(enumClass);
        if (names.contains(value)) {
            return true;
        }
        MyConstraintUtil.changeConstraintMessageTemplate(context, "正确的值包括：【" + Joiner.on(",").join(names) + "】");
        return false;
    }

}
