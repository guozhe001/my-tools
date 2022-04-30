package com.nicai.experience.p3c.chapterone.sixth;

import com.google.common.hash.HashCode;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashCodeEquals {

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
