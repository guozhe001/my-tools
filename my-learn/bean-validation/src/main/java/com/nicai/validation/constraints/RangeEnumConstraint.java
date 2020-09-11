package com.nicai.validation.constraints;

import com.nicai.validation.constraintvalidators.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举值校验
 *
 * @author guozhe
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidator.class})
public @interface RangeEnumConstraint {
    String message() default "值不正确";

    Class<? extends Enum> value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
