# Bean Validation 的应用
在任何时候，我们的应用程序要处理一个的业务逻辑，数据校验是我们必须要考虑和面对的事情；它会出现在我们应用程序的许多不同层中，从表示层到持久层。很多时候，必须在每个层中实施完全相同的验证，这既耗时又容易出错。为了避免必须在每一层重新实现这些验证，许多开发人员会将验证的代码直接复制粘贴到其类中，从而使它们重复并且杂乱无章。(此时打开代码AssetManageServiceImpl#receiveAsset)

Bean Validation 是一个运行时的数据验证框架，在验证之后验证的错误信息会被马上返回(此时打开代码MakeLoanController#makeLoanPlus)

从刚才的代码比较可以看出，Bean Validation可以极大的简化因校验而写的代码量，这就是今天和大家一起学习Bean Validation的原因。

## 为什么使用？
优雅

## 如何使用
### 项目中必须引用以下jar包
```xml
    <dependencies>
    <!--bean validation规范-->
    <dependency>
      <groupId>javax.validation</groupId>
      <artifactId>validation-api</artifactId>
      <version>2.0.1.Final</version>
    </dependency>
    <!--bean validation规范实现-->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>6.0.17.Final</version>
    </dependency>
    </dependencies>
```
### java版本与规范版本对应关系
* JSR-303伴随着JAVAEE 6在2009年发布，Hibernate实现版本4.3.1.Final
* JSR-349伴随着JAVAEE 7在2013年发布，Hibernate实现版本5.1.1.Final
* JSR-380伴随着JAVAEE 8在2017年8月发布,完全兼容低版本的JAVASE,Hibernate实现版本6.0.1.Final

### 代码中如何使用
#### 字段级别的约束 FieldLevelConstraintsAO
```java
package com.nicai.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 字段级别的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
@Data
public class FieldLevelConstraintsAO {

    @NotBlank
    private String name;

}

```
#### 属性（get方法）级别的约束 PropertyLevelConstraintsAO
```java
package com.nicai.ao;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * 属性（非方法）级别的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
public class PropertyLevelConstraintsAO {

    /**
     * 姓名
     */
    private String name;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 为什么是属性（非方法）级别的约束示例
     * 因为这个方法并没有被校验
     */
    @NotNull
    public String giveMeName() {
        return this.name;
    }

    /**
     * 为什么是属性（非方法）级别的约束示例
     * 因为这个方法并没有被校验
     */
    public @NotNull String giveMeName2() {
        return this.name;
    }

    /**
     * 此处为了演示欺骗校验器的情况，假装此方法是某个boolean字段的get方法让校验器校验此方法的返回值
     * 这样使用容易产生误会，还是不要使用；原因引用阿里java开发手册中的一个建议：
     * <p>
     * 阿里巴巴
     * 【强制】POJO 类中布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。
     * 反例:定义为基本数据类型Boolean isDeleted的属性，它的方法也是isDeleted()，RPC框架在反向解析的时候，“误以为”对应的属性名称是 deleted，导致属性获取不到，进而抛
     * 出异常。
     *
     * @return 名字不为null时返回true，否则返回false
     */
    @AssertTrue
    public boolean isNameIsNull() {
        return null != this.name;
    }

}

```
#### 容器元素的约束 ContainerElementConstraintsAO
```java
package com.nicai.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

/**
 * 容器元素的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
@Data
public class ContainerElementConstraintsAO {
    /**
     * 姓名列表
     */
    private List<@NotBlank String> names;
    /**
     * 姓名和年龄的对应关系
     */
    private Map<@NotBlank String, @Positive Integer> nameAgeMap;
}

```
#### 类级别的约束 ClassLevelConstraintsAO
```java
package com.nicai.ao;

import com.nicai.validation.CrossDateParameterValid;
import com.nicai.validation.constraints.ValidCrossDateParameter;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 字段级别的约束示例
 * @author guozhe
 * @date 2019-12-03
 */
@Data
@ValidCrossDateParameter(message = "预计放款时间必须在实际放款时间之前")
public class ClassLevelConstraintsAO implements CrossDateParameterValid {

    /**
     * 预计放款时间
     */
    @NotNull
    private Date loanDay;
    /**
     * 实际放款时间
     */
    @NotNull
    private Date loanTime;

    @Override
    public Date getEarlierDate() {
        return loanDay;
    }

    @Override
    public Date getLaterDate() {
        return loanTime;
    }

    /**
     * 此处用到了属性校验的一个特性，只会校验get方法和（is开头的方法是boolean类型的字段的get方法），
     */
    @AssertTrue(message = "预计放款时间必须在实际放款时间之前")
    public boolean isLoanDayBeforeLoanTime() {
        return this.loanDay.before(this.loanTime);
    }

    /**
     * 此处用到了属性校验的一个特性，只会校验get方法和（is开头的方法是boolean类型的字段的get方法），
     */
    public @AssertTrue boolean isLoanDayBeforeLoanTime2() {
        return this.loanDay.before(this.loanTime);
    }
}

```
#### 约束的继承  BorrowerAO
```java
package com.nicai.ao;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 约束的继承演示
 * <p>
 * 借款人信息
 *
 * @author guozhe
 * @date 2019-12-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BorrowerAO extends UserAO {

    /**
     * 电话号码
     */
    @NotNull
    private Long mobile;

    /**
     * 电子邮件
     */
    @Email
    private String email;
    /**
     * 联系人列表
     */
    @NotEmpty(message = "联系人不能为空")
    private List<@Valid ContactAO> contact;
}

```
#### 类地图-级联验证 RequestAO


## 不要重复造轮子，目前有哪些轮子
1. Bean Validation中的约束（constraints） 示例：RequestAO
1. Hibernate Validator 扩展的约束（constraint） 示例：RequestAO
```java
package com.nicai.ao;

import com.nicai.constant.Constants;
import com.nicai.enums.PaySource;
import com.nicai.validation.constraints.RangeEnumConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 某借贷业务请求AO
 * 示例所有的现有的constraint
 *
 * @author guozhe
 * @date 2019-11-08
 */
@Data
public class RequestAO {

    // Bean Validation 规范 constraint;使用JSR-380版本 start
    /**
     * 请求ID
     */
    @Null
    private String requestId;

    /**
     * 贷款人信息
     */
    @NotNull(message = "用户信息不允许为null")
    @Valid
    private BorrowerAO user;

    /**
     * 目标资金渠道,可以有多个目标资金渠道
     */
    @Size(min = 0, max = 3, message = "目标资金渠道的个数必须大于等于0小于等于3")
    @NotEmpty
    private List<@RangeEnumConstraint(value = PaySource.class, message = "目标资金渠道的值不正确") String> targetSources;

    /**
     * 签约金额
     */
    @Digits(integer = 6, fraction = 2, message = "签约金额整数位数不能超过12位，小数位数不能超过2位")
    @DecimalMax(value = "200000", message = "个人在同一平台上最多借款不能超过20万元")
    private BigDecimal signedAmount;

    /**
     * 放款金额
     */
    @DecimalMin(value = "0", inclusive = false, message = "放款金额必须大于0")
    @PositiveOrZero
    private BigDecimal amount;

    /**
     * 是否是男性
     */
    @AssertTrue(message = "借款人必须是男性，没有性别歧视；男人负责赚钱养家,女人负责貌美如花")
    private Boolean male;

    /**
     * 是否是女性
     */
    @AssertFalse(message = "借款人不能是女性，没有性别歧视；男人负责赚钱养家,女人负责貌美如花")
    private Boolean female;

    /**
     * 首期账单日
     */
    @Future(message = "首期账单日必须在当前时间之后")
    @FutureOrPresent(message = "首期账单日必须是当前时间或之后")
    private Date firstDueDate;

    /**
     * 实际放款时间
     */
    @Past(message = "实际放款时间必须在当前时间之前")
    @PastOrPresent(message = "实际放款时间必须是当前时间或之前")
    private Date loanTime;

    /**
     * 借款人年龄
     */
    @Min(22)
    @Max(50)
    @Positive(message = "必须是正数")
    private Integer age;

    /**
     * 邮箱
     * <p>
     * {@code NotBlank}和{@code NotEmpty}用在字符串上的时候效果是一样的
     */
    @Pattern(regexp = Constants.EMAIL_REGEXP)
    @Email
    @NotBlank
    @NotEmpty
    @Email
    private String email;

    /**
     * 减免金额
     */
    @Negative(message = "必须是负数")
    @NegativeOrZero(message = "必须是负数")
    private BigDecimal reduceAmount;


    // Bean Validation 规范 constraint;使用JSR-380版本 end


    // Hibernate Validator 扩展的约束（constraint）演示start

    /**
     * 合同编号
     */
    @Length(min = 8, max = 32)
    private String contractCode;

    /**
     * 借款人年龄
     * 两边都是闭区间
     * 即age1必须大于等于22小于等于55
     */
    @Range(min = 22, max = 55)
    @Positive(message = "必须是正数")
    private Integer age1;

    // Hibernate Validator 扩展的约束（constraint）演示end


}

```

## 使用这些约束（constraint）时有哪些坑
0. 约束有类型的要求，但是在编译时无法做类型检查。示例 TypeCheckingAO
```java
package com.nicai.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 0. 约束有类型的要求，但是在编译时无法做类型检查的示例
 *
 * @author guozhe
 * @date 2019-12-04
 */
@Data
public class TypeCheckingAO {

    /**
     * 年龄
     * "@NotBlank" 只能用在字符上面，但是此处用了并没有在编译时报错，需要注意
     */
    @NotBlank
    private Integer age;
}

```
1. 约束用在方法入参中，但是此约束并没有声明可以用在方法入参中而导致的约束不生效 ValidationController#pushToPaySource
```java
package com.nicai.controller;

import com.nicai.ao.TransOutput;
import com.nicai.ao.UserAO;
import com.nicai.config.MethodValidationConfig;
import com.nicai.enums.PaySource;
import com.nicai.validation.constraints.RangeEnumConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
@Controller
@Validated
@RequestMapping("validation")
public class ValidationController {

    /**
     * 演示spring的方法入参校验
     * 1、必须配置bean: MethodValidationPostProcessor
     * 2、类上必须加@Validated注解
     * 3、注解必须支持用在方法入参中，即：ElementType.PARAMETER
     *
     * @param paySource 资金渠道
     * @return 通用返回报文
     * @see MethodValidationConfig
     */
    @ResponseBody
    @GetMapping(value = "/pushToPaySource")
    public TransOutput pushToPaySource(@RequestParam("paySource") @RangeEnumConstraint(value = PaySource.class, message = "资金渠道不正确") @NotBlank String paySource) {
        log.info("push bid to paySource {}", paySource);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("have push bid to %s", paySource));
    }
}
```
## 不能解决什么问题
* 依赖数据库的校验，如bean的某个属性必须和数据库中某个表的某个字段的值一致

## 自定义约束
### 自定义一个简单的约束需要哪些步骤
* 创建一个约束注解
* 实现一个校验器
* 定义一个默认的错误信息

### 创建一个约束注解
根据验证API规范要求，所有的约束注解必须有以下三个属性

* 一个有默认返回值的```message```属性为了在违反约束时创建错误信息
* 一个分组验证用的属性```groups```，必须定义为```Class<?>[]```（即Class数组）
* 一个提供给客户端自定义的属性```payload```，验证API不会使用
例：
```java
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

```
### 创建一个约束校验器
约束注解已经定义成功，现在还需要创建一个约束校验器来校验有约束注解的元素；直接实现```ConstraintValidator```接口即可

* ```ConstraintValidator```接口有两个由实现类自定义的类型参数；第一个必须是一个注解，第二个是待校验元素类型
* ```initialize()```方法让我们能够获取到注解中的属性值
* ```isValid()```方法是具体的校验逻辑；注意验证API建议将空值视为有效如果null不是元素的有效值，则应使用```@NotNull```显式进行注释

例：
```java
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

```
### 知道如何自定义约束注解，如何自查创建的是好的约束还是不太好的约束？
* 反例 CollectionCompanyValidator
* 正例 EnumValidator；演示：Person、ValidationController#pushToPaySource

## 分组校验
```java
package com.nicai.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author guozhe
 * @date 2019-12-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Person {

    /**
     * 头发长度，男学生一般要求头发不能太长，所以头发长度不能超过10厘米
     * 此字段覆盖了父类的字段，相应的属性注解也覆盖了；虽然父类又{@code @Min(0)}但是并没有生效，所以在此处要有{@code @Min(0)}
     */
    @Range(max = 10, groups = PersonGroup.MaleStudentGroup.class, message = "本校规定男学生头发长度不能超过10厘米")
    @Range(min = 10, groups = PersonGroup.FemaleStudentGroup.class, message = "本校规定女学生头发长度不能短于10厘米")
    @Min(0)
    private Integer hairLength;

}

```

## 与spring配合使用

### 入参是基本数据类型的包装类校验：ValidationController#pushToPaySource
```java
package com.nicai.controller;

import com.nicai.ao.TransOutput;
import com.nicai.ao.UserAO;
import com.nicai.config.MethodValidationConfig;
import com.nicai.enums.PaySource;
import com.nicai.validation.constraints.RangeEnumConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
@Controller
@Validated
@RequestMapping("validation")
public class ValidationController {

    @ResponseBody
    @GetMapping(value = "/hello")
    public TransOutput hello(@RequestParam("name") @NotBlank(message = ".name不能为空") String name,
                             @RequestParam("age") @NotNull(message = ".age不能为null") @Min(value = 18, message = ".age必须大于等于十八岁") Integer age) {
        log.info("hello {}, age = {}", name, age);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("您好%s，您今年%s岁，欢迎光临", name, age));
    }

    /**
     * 演示入参直接指定对应的枚举类型;
     * 定义接口时不建议使用这种方式，因为如果传错了值会报类型转换错误：
     * java.lang.IllegalArgumentException: No enum constant com.share.enums.PaySource.***
     * 接口定义可以使用下面的方法，使返回报文更友好，可控
     * <p>
     * 此处的异常已经被ControllerExceptionAdvance#methodArgumentTypeMismatchExceptionHandler拦截处理，如果不做拦截异常信息更不友好
     *
     * @param paySource 资金渠道
     * @return 通用返回报文
     */
    @ResponseBody
    @GetMapping(value = "/pushToPaySourceEnum")
    public TransOutput pushToPaySourceEnum(@RequestParam("paySource") @NotNull PaySource paySource) {
        log.info("push bid to paySource {}", paySource);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("have push bid to %s", paySource));
    }

    /**
     * 演示spring的方法入参校验
     * 1、必须配置bean: MethodValidationPostProcessor
     * 2、类上必须加@Validated注解
     * 3、注解必须支持用在方法入参中，即：ElementType.PARAMETER
     *
     * @param paySource 资金渠道
     * @return 通用返回报文
     * @see MethodValidationConfig
     */
    @ResponseBody
    @GetMapping(value = "/pushToPaySource")
    public TransOutput pushToPaySource(@RequestParam("paySource") @RangeEnumConstraint(value = PaySource.class, message = "资金渠道不正确") @NotBlank String paySource) {
        log.info("push bid to paySource {}", paySource);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("have push bid to %s", paySource));
    }

}

```
### 入参是bean的校验：ValidationController#receiveUser
```java
package com.nicai.controller;

import com.nicai.ao.TransOutput;
import com.nicai.ao.UserAO;
import com.nicai.config.MethodValidationConfig;
import com.nicai.enums.PaySource;
import com.nicai.validation.constraints.RangeEnumConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
@Controller
@Validated
@RequestMapping("validation")
public class ValidationController {

    @ResponseBody
    @PostMapping(value = "/receiveUser")
    public TransOutput receiveUser(@RequestBody @Valid UserAO user) {
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("receiveUser name=%s", user.getName()));
    }
}

```

# 未解答的问题
## 那些写指定校验器为```@Constraint(validatedBy = { })```是如何找到对应的校验器的？

# 参考资料
* [深入了解数据校验：Bean Validation 2.0（JSR380）](https://segmentfault.com/a/1190000019828246)
* [JSR 303 - Bean Validation 介绍及最佳实践](https://www.ibm.com/developerworks/cn/java/j-lo-jsr303/index.html)
* [SpringMVC中实现Bean Validation(JSR 303 JSR 349 JSR 380)](https://www.cnblogs.com/passedbylove/p/11395911.html)
* [Hibernate Validator:The Bean Validation reference implementation.](http://hibernate.org/validator/)
* [当validatedBy为空时,HibernateValidator如何找到ConstraintValidator](http://www.voidcn.com/article/p-bjuuliuy-bws.html)
* [Spring方法级别数据校验：@Validated + MethodValidationPostProcessor](http://www.mamicode.com/info-detail-2736166.html)




