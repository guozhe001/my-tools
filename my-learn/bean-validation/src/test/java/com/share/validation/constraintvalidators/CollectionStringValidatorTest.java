package com.share.validation.constraintvalidators;


import com.share.exception.MyCommonException;
import com.share.util.ValidatorUtil;
import com.share.validation.constraints.CollectionStringConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020/07/30
 */
public class CollectionStringValidatorTest {

    @Test(expected = MyCommonException.class)
    public void isValid() {
        ValidatorUtil.validateWithException(new Person("nicai"));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person {
        @CollectionStringConstraint({"hello", "hi"})
        private String name;
    }

}