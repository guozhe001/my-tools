package com.nicai.algorithm.other;

import cn.hutool.core.lang.Assert;
import com.google.common.collect.Sets;
import lombok.EqualsAndHashCode;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

/**
 * 贪心算法：
 * 教室课程安排
 */
public class ClassRoom {

    public Set<Course> plan(Set<Course> curses) {
        Set<Course> result = Sets.newHashSet();
        plan(result, curses, 0);
        return result;
    }

    public Set<Course> plan(Set<Course> result, Set<Course> curses, final double endTime) {
        Optional<Course> min = curses.stream().filter(course -> course.beginTime >= endTime).min(Comparator.comparingDouble(c -> c.beginTime));
        if (min.isPresent()) {
            Course first = min.get();
            result.add(first);
            return plan(result, curses, first.endTime);
        } else {
            return result;
        }
    }


    /**
     * 课程信息
     */
    @EqualsAndHashCode
    final class Course {
        public Course(String name, double beginTime, double endTime) {
            Assert.isTrue(endTime > beginTime);
            this.name = name;
            this.beginTime = beginTime;
            this.endTime = endTime;
        }

        /**
         * 课程名称
         */
        String name;
        /**
         * 开始时间,如7表示7点
         */
        double beginTime;
        /**
         * 结束时间,如8表示8点
         */
        double endTime;
    }

}
