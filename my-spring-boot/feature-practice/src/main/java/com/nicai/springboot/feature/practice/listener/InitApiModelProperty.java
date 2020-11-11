package com.nicai.springboot.feature.practice.listener;

import cn.hutool.core.util.ClassUtil;
import com.nicai.springboot.feature.practice.annotations.ApiModelPropertyAdvance;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 此类是为了在项目启动时，动态的更新指定类的ApiModelProperty的notes信息；以达到提供的swagger-ui的信息动态更新；
 * <p>如何达到此目的
 * 1、在需要被修改的类的属性上添加ApiModelPropertyAdvance注解
 * 2、把第一步的类添加到InitApiModelProperty的TO_BE_UPDATE_PROPERTY_CLASSES数组中
 *
 * @author guozhe
 */
@Slf4j
@Component
public class InitApiModelProperty implements ApplicationContextAware {

    /**
     * 获取注解
     */
    private static final String MEMBER_VALUE = "memberValues";
    /**
     * ApiModelProperty中的notes属性
     */
    private static final String API_MODEL_PROPERTY_NOTE = "notes";

    /**
     * 实现ApplicationContextAware接口主要是为了在项目启动时执行操作
     *
     * @param applicationContext 上下文
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        log.info("hi, i'm InitApiModelProperty");
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation("com.nicai.springboot.feature.practice.vo", ApiModelPropertyAdvance.class);
        try {
            for (Class<?> clazz : classes) {
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field field : declaredFields) {
                    try {
                        updateFieldApiModelPropertyNotes(clazz, field);
                    } catch (Exception e) {
                        log.error("Class={} Field={} 修改@ApiModelProperty的notes值失败 {}", clazz.getName(), field.getName(), e.getMessage(), e);
                    }
                }
            }
        } catch (Exception e) {
            log.error("动态的更新指定类的ApiModelProperty的notes信息,errMsg={}", e.getMessage(), e);
        }
    }

    /**
     * 如果field字段同时有@ApiModelPropertyAdvance和ApiModelProperty注解
     * 则更新clazz的field字段ApiModelProperty注解的notes信息
     *
     * @param clazz 需要更新的类
     * @param field 需要更新的字段
     */
    private void updateFieldApiModelPropertyNotes(Class<?> clazz, Field field) throws NoSuchFieldException, IllegalAccessException {
        ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
        ApiModelPropertyAdvance apiModelPropertyAdvance = field.getAnnotation(ApiModelPropertyAdvance.class);
        if (Objects.nonNull(apiModelProperty) && Objects.nonNull(apiModelPropertyAdvance)) {
            log.debug("Class={} Field={} @ApiModelProperty的notes的原始值={}", clazz.getName(), field.getName(), apiModelProperty.notes());
            InvocationHandler h = Proxy.getInvocationHandler(apiModelProperty);
            Field hField = h.getClass().getDeclaredField(MEMBER_VALUE);
            hField.setAccessible(true);
            Map memberValues = (Map) hField.get(h);
            memberValues.put(API_MODEL_PROPERTY_NOTE, getNewValue(apiModelPropertyAdvance));
            log.debug("Class={} Field={} @ApiModelProperty的notes修改后的值={}", clazz.getName(), field.getName(), apiModelProperty.notes());
        }
    }

    /**
     * 获取注解ApiModelPropertyAdvance的枚举值的所有元素
     *
     * @param apiModelPropertyAdvance 此注解是ApiModelProperty的增强
     * @return ApiModelPropertyAdvance中枚举的所有元素
     */
    private static String getNewValue(ApiModelPropertyAdvance apiModelPropertyAdvance) {
        Class<? extends Enum> value = apiModelPropertyAdvance.value();
        StringBuilder sb = new StringBuilder("包括：【\n");
        for (Enum enumValue : value.getEnumConstants()) {
            sb.append(enumValue.name()).append("(").append(enumValue).append(");\n");
        }
        sb.append("】");
        return sb.toString();
    }

}
