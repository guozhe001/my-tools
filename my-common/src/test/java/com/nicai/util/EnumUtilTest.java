package com.nicai.util;

import com.nicai.exception.NicaiException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import java.util.stream.Collector;

/**
 * @author guozhe
 * @date 2020/07/14
 */
@Slf4j
public class EnumUtilTest {

    /**
     * 测试时使用的枚举类型
     */
    private static final Class<Collector.Characteristics> TEST_ENUM_CLASS = Collector.Characteristics.class;

    @Test
    public void getValue() {
        Collector.Characteristics value = EnumUtil.getValue(TEST_ENUM_CLASS, "CONCURRENT", "");
        Assert.assertEquals(Collector.Characteristics.CONCURRENT, value);
    }

    @Test(expected = NicaiException.class)
    public void getValueExpectNicaiException() {
        EnumUtil.getValue(TEST_ENUM_CLASS, "hello", "");
    }

    @Test
    public void getEnumValuesString() throws Exception {
        String valuesString = Whitebox.invokeMethod(EnumUtil.class, "getEnumValuesString", TEST_ENUM_CLASS);
        log.info("testClass = {}, valuesString = {}", TEST_ENUM_CLASS.getName(), valuesString);
        Assert.assertEquals("CONCURRENT, UNORDERED, IDENTITY_FINISH", valuesString);
    }
}