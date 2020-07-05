package com.nicai.experience.core;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class PhoneNumberTest {

    private static final String VALUE = "hello";

    @Test
    public void test() {
        Map<PhoneNumber, String> map = Maps.newHashMap();
        PhoneNumber phoneNumber = new PhoneNumber(1, 2, 1238);
        int hashCode1 = phoneNumber.hashCode();
        int hashCode2 = phoneNumber.hashCode();
        log.info("same phoneNumber, hashCode1={}, hashCode2={}", hashCode1, hashCode2);
        map.put(phoneNumber, VALUE);
        PhoneNumber anotherPhoneNumber = new PhoneNumber(1, 2, 1238);
        Assert.assertEquals(phoneNumber, anotherPhoneNumber);
        Assert.assertNull(map.get(anotherPhoneNumber));
    }

    @Test
    public void test1() {
        Map<PhoneNumberOverrideHashCode, String> map = Maps.newHashMap();
        PhoneNumberOverrideHashCode phoneNumber = new PhoneNumberOverrideHashCode(1, 2, 1238);
        map.put(phoneNumber, VALUE);
        PhoneNumberOverrideHashCode anotherPhoneNumber = new PhoneNumberOverrideHashCode(1, 2, 1238);
        Assert.assertEquals(phoneNumber, anotherPhoneNumber);
        Assert.assertEquals(VALUE, map.get(anotherPhoneNumber));
    }
}