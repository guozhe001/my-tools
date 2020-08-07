package com.nicai.experience.p3c.chapterone.sixth;

import com.google.common.collect.Sets;
import com.google.common.hash.HashCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * 阿里巴巴Java开发手册
 * 1. 【强制】关于hashCode和equals的处理，遵循如下规则:
 * 1) 只要重写 equals，就必须重写 hashCode。
 * 2) 因为 Set 存储的是不重复的对象，依据 hashCode 和 equals 进行判断，所以 Set 存储的对象必须重写 这两个方法。
 * 3) 如果自定义对象作为 Map 的键，那么必须覆写 hashCode 和 equals。
 * 说明:String 因为重写了 hashCode 和 equals 方法，所以我们可以愉快地使用 String 对象作为 key 来使 用。
 *
 * @author guozhe
 */
@Slf4j
public class HashCodeEquals {

    public static void main(String[] args) {
        testDogWithEquals();
        testPerson();
    }

    public static void testDogWithEquals() {
        Set<Dog> dogs = Sets.newHashSet();
        dogs.add(new Dog(1L, "huahua", 3));
        dogs.add(new Dog(1L, "huahua", 3));
        dogs.add(new Dog(2L, "dahuang", 2));
        dogs.add(new Dog(3L, "mimi", 2));
        log.info("dogs.size={}", dogs.size());
    }

    public static void testPerson() {
        Set<Person> sets = Sets.newHashSet();
        // 其实第一条和第二条应该是一样的
        sets.add(new Person(1L, "zhangsan", 18));
        sets.add(new Person(1L, "zhangsan", 18));
        sets.add(new Person(2L, "lisi", 19));
        sets.add(new Person(3L, "wangwu", 20));
        log.info("sets.size={}", sets.size());
    }

    @Setter
    @Getter
    @ToString
    public static class Dog extends Animal {
        @Override
        public int hashCode() {
            return HashCode.fromLong(getId()).asInt();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            return getId().equals(((Dog) obj).getId());
        }

        public Dog(Long id, String name, Integer age) {
            super(id, name, age);
        }

    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    public static class Animal {
        private Long id;
        private String name;
        private Integer age;
    }

    @Getter
    @Setter
    @ToString
    public static class Person extends Animal {
        public Person(Long id, String name, Integer age) {
            super(id, name, age);
        }
    }
}
