package com.nicai.validation.constraintvalidators;

import com.nicai.validation.constraints.DecimalScaleConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数值类型有效数字验证
 *
 * @author guozhe
 * @date 2017/11/27
 */
public class DecimalScaleValidator implements ConstraintValidator<DecimalScaleConstraint, BigDecimal> {
    /**
     * 有效数字位数
     */
    private int scale;

    @Override
    public void initialize(DecimalScaleConstraint decimalScaleConstraint) {
        this.scale = decimalScaleConstraint.value();
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        /*
         例如，有效数字位数=6
         0.0001   满足
         0.000100 满足
         0.0001000满足
         0.0001001不满足
         有效数字不能超过指定位数，如果设置了scale之后的值和原值一样，则说明在有效数字的范围内
         */
        return value.setScale(scale, RoundingMode.HALF_UP).compareTo(value) == 0;
    }
}
