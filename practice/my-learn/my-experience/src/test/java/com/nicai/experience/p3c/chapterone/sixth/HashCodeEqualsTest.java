package com.nicai.experience.p3c.chapterone.sixth;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * HashCodeEqualsTest
 *
 * @author guozhe
 * @date 2020/09/23
 */
@Slf4j
public class HashCodeEqualsTest {

    @Test
    public void testDogWithEquals() {
        Set<HashCodeEquals.Dog> dogs = Sets.newHashSet();
        dogs.add(new HashCodeEquals.Dog(1L, "huahua", 3));
        dogs.add(new HashCodeEquals.Dog(1L, "huahua", 3));
        dogs.add(new HashCodeEquals.Dog(2L, "dahuang", 2));
        dogs.add(new HashCodeEquals.Dog(3L, "mimi", 2));
        log.info("dogs.size={}", dogs.size());
        Assert.assertEquals(3, dogs.size());
    }

    @Test
    public void testPerson() {
        Set<HashCodeEquals.Person> sets = Sets.newHashSet();
        // 其实第一条和第二条应该是一样的
        sets.add(new HashCodeEquals.Person(1L, "zhangsan", 18));
        sets.add(new HashCodeEquals.Person(1L, "zhangsan", 18));
        sets.add(new HashCodeEquals.Person(2L, "lisi", 19));
        sets.add(new HashCodeEquals.Person(3L, "wangwu", 20));
        log.info("sets.size={}", sets.size());
        Assert.assertEquals(4, sets.size());
    }


}