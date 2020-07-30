package com.share.validation;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Joiner;

import javax.validation.ConstraintValidatorContext;

/**
 * @author guozhe
 * @date 2019-12-19
 */
public class MyConstraintUtil {

    private MyConstraintUtil() {

    }

    /**
     * 修改约束的错误信息
     * 在原错误信息上增加用户自定义的扩展错误信息
     *
     * @param context       约束上下文
     * @param extendMessage 扩展错误信息
     */
    public static void changeConstraintMessageTemplate(ConstraintValidatorContext context, String extendMessage) {
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on(";").join(defaultConstraintMessageTemplate, extendMessage)).addConstraintViolation();
    }

    /**
     * 修改约束的错误信息
     * 在原错误信息上增加用户自定义的扩展错误信息
     *
     * @param context       约束上下文
     * @param correctValues 正确的值数组
     */
    public static void changeConstraintMessageTemplate(ConstraintValidatorContext context, String[] correctValues) {
        String extendMessage = StrUtil.format("正确的值包括：【{} 】", Joiner.on(",").join(correctValues));
        changeConstraintMessageTemplate(context, extendMessage);
    }
}
