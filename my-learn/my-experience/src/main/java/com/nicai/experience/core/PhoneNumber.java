package com.nicai.experience.core;

import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * Effective Java 第九条 覆盖equals时总要覆盖hashCode
 * 覆盖了equals但是没有覆盖hashCode测试
 * <p>
 * 下面是约定的内容,摘自 Object规范[JavaSE6]:
 * 1、在应用程序的执行期间,只要对象的 equals方法的比较操作所用到的信息没有被修改,
 * 那么对这同一个对象调用多次, hashCode法都必须始终如一地返回同一个整数。在同
 * 一个应用程序的多次执行过程中,每次执行所返回的整数可以不一致。
 * 2、如果两个对象根据 equals(Object)方法比较是相等的,那么调用这两个对象中任意一个对
 * 象的 hashCode方法都必须产生同样的整数结果。
 * 3、如果两个对象根据equals(Object)方法比较是不相等的,那么调用这两个对象中任意一个
 * 对象的 hashCode方法,则不一定要产生不同的整数结果。但是程序员应该知道,给不相
 * 等的对象产生截然不同的整数结果,有可能提高散列表(hash table)的性能。
 *
 * @author guozhe
 */
public class PhoneNumber {

    /**
     * 区域编码
     */
    private final short areaCode;

    /**
     * 电话号码前缀
     */
    private final short prefix;

    /**
     * 电话
     */
    private final short lineNumber;


    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNumber);
    }
}
