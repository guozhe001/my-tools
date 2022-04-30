package com.nicai.springboot.feature.practice.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 此注解是ApiModelProperty的增强，主要是为了提供的swagger的API的model中如果值在某个枚举类的范围内
 * 则通过此类标注这个字段的值的取值范围属于哪个枚举
 * <p><b>如何使用此注解：</b>
 * <p>1、此注解必须和同时注解到一个字段才能生效
 * <p>正例:
 * <p>{@code @ApiModelProperty(notes = "归属子公司")}
 * <p>{@code @ApiModelPropertyAdvance(BelongToSubsidiary.class)}
 * <p>{@code private String belongToSubsidiary;}
 * <p>2、此注解只适用于接口字段传枚举value的情况：
 * 正例:
 * <p>PaySource枚举：接口字段要求传"ONLINE_IQIANJIN"；
 * BelongToSubsidiary枚举：接口字段要求传"LS_PHPX"
 * <p>反例：
 * ServiceFeeCollectTypeEnum枚举：
 * 如果接口要求传"0"或者是传"放款时收取服务费"都不可以使用此注解
 * SERVICE_FEE_COLLECT_WHEN_MAKELOAN(0, "放款时收取服务费")
 * <p>3、被注解的字段必须是private的
 * <p>4、被注解的字段在程序启动时由InitApiModelProperty类通过反射机制最终更改同样注解在此字段上的ApiModelProperty的notes值
 *
 * @author guozhe
 * @see io.swagger.annotations.ApiModelProperty
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelPropertyAdvance {

    /**
     * 被注解字段的值对应的枚举
     */
    Class<? extends Enum> value();

    enum None {

    }

}
