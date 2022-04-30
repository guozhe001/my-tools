package com.nicai.validation.constraints;

import com.nicai.validation.constraintvalidators.RangeStringValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 字符串范围约束
 * 校验字段的值必须在指定的范围内
 * ø
 *
 * @author guozhe
 * @date 2020/07/30
 */
@Documented
@Constraint(validatedBy = {RangeStringValidator.class})
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface RangeStringConstraint {

    /**
     * 取值范围
     *
     * @return 指定的取值范围
     */
    String[] value();

    String message() default "取值范围不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
