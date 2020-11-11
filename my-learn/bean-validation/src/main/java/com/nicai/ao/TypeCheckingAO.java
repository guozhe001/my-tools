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
