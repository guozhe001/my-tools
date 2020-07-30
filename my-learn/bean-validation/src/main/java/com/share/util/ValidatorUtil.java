package com.share.util;

import com.share.exception.MyCommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
public class ValidatorUtil {

    public static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidatorUtil() {

    }

    /**
     * 校验指定实体，如果校验不通过则抛异常
     *
     * @param t   具体的实体
     * @param <T> 实体的类型
     */
    public static <T> void validateWithException(T t) {
        Set<ConstraintViolation<T>> set = validate(t);
        if (!CollectionUtils.isEmpty(set)) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> error : set) {
                printLog(error);
                validateError.append(formatErrorMsg(error.getPropertyPath().toString(), error.getMessage(), error.getInvalidValue()));
            }
            throw new MyCommonException(validateError.toString());
        }
    }

    /**
     * 校验指定实体
     *
     * @param t   具体的实体
     * @param <T> 实体的类型
     * @return 不符合约束的结果集
     */
    public static <T> Set<ConstraintViolation<T>> validate(T t) {
        return VALIDATOR.validate(t);
    }

    /**
     * 带分组的校验指定实体
     *
     * @param t     具体的实体
     * @param <T>   实体的类型
     * @param group 校验分组
     * @return 不符合约束的结果集
     */
    public static <T> Set<ConstraintViolation<T>> validate(T t, Class<?> group) {
        if (null != group) {
            return VALIDATOR.validate(t, group);
        }
        return validate(t);
    }

    /**
     * 打印日志
     *
     * @param error 不符合约束的结果
     * @param <T>   类型
     */
    private static <T> void printLog(ConstraintViolation<T> error) {
        log.debug("error.getMessage():{}", error.getMessage());
        log.debug("error.getPropertyPath():{}", error.getPropertyPath());
        log.debug("error.getConstraintDescriptor():{}", error.getConstraintDescriptor());
        log.debug("error.getExecutableParameters():{}", error.getExecutableParameters());
        log.debug("error.getExecutableReturnValue():{}", error.getExecutableReturnValue());
        log.debug("error.getInvalidValue():{}", error.getInvalidValue());
        log.debug("error.getLeafBean():{}", error.getLeafBean());
        log.debug("error.getMessageTemplate():{}", error.getMessageTemplate());
        log.debug("error.getRootBeanClass():{}", error.getRootBeanClass());
        log.debug("error.getRootBean():{}", error.getRootBean());
    }

    /**
     * 格式化错误信息
     *
     * @param set 不符合约束的结果集
     * @return 组装后的错误信息
     */
    public static String formatErrorMsg(Set<ConstraintViolation<?>> set) {
        StringBuilder validateError = new StringBuilder();
        for (ConstraintViolation<?> error : set) {
            validateError.append(formatErrorMsg(error.getPropertyPath().toString(), error.getMessageTemplate(), error.getInvalidValue()));
        }
        return validateError.toString();
    }

    /**
     * 格式化错误信息
     *
     * @param allErrors 错误字段列表
     * @return 组装后的错误信息
     */
    public static String formatErrorMsg(List<FieldError> allErrors) {
        StringBuilder validateError = new StringBuilder();
        for (FieldError objectError : allErrors) {
            validateError.append(formatErrorMsg(objectError.getField(), objectError.getDefaultMessage(), objectError.getRejectedValue()));
        }
        return validateError.toString();
    }

    /**
     * 格式化错误信息
     *
     * @param fieldName    字段名称
     * @param message      错误信息
     * @param invalidValue 不合法的值
     * @return 组装后的错误信息
     */
    private static String formatErrorMsg(String fieldName, String message, Object invalidValue) {
        return String.format("[%s%s,invalidValue=%s] ;", fieldName, message, invalidValue);
    }

}
