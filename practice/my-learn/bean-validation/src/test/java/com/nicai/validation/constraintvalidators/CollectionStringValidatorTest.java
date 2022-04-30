package com.nicai.validation.constraintvalidators;


import com.nicai.exception.NicaiException;
import com.nicai.util.ValidatorUtil;
import com.nicai.validation.constraints.RangeStringConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2020/07/30
 */
public class CollectionStringValidatorTest {

    @Test(expected = NicaiException.class)
    public void isValid() {
        ValidatorUtil.validateWithException(new Person("nicai"));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person {
        @RangeStringConstraint({"hello", "hi"})
        private String name;
    }

}