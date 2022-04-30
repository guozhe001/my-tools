package com.nicai.ao;

import com.nicai.enums.GenderEnum;
import com.nicai.util.PrintUtil;
import com.nicai.util.ValidatorUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-12-26
 */
public class PersonTest {

    @Test
    public void testGenderError() {
        Person person = new Person();
        person.setGender("test");
        Set<ConstraintViolation<Person>> validate = ValidatorUtil.validate(person);
        Assert.assertEquals(1, validate.size());
        PrintUtil.print(validate, "testGenderError");
    }

    @Test
    public void testGender() {
        Person person = new Person();
        person.setGender(GenderEnum.MALE.name());
        Set<ConstraintViolation<Person>> validate = ValidatorUtil.validate(person);
        Assert.assertEquals(0, validate.size());
    }

}