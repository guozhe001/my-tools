package com.nicai.algorithm.other;

import com.google.common.collect.Sets;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ClassRoomTest {
    
    private static final ClassRoom.Course ART = new ClassRoom().new Course("美术", 9, 10);
    private static final ClassRoom.Course ENGLISH = new ClassRoom().new Course("英语", 9.5, 10.5);
    private static final ClassRoom.Course MATHEMATICS = new ClassRoom().new Course("数学", 10, 11);
    private static final ClassRoom.Course COMPUTER = new ClassRoom().new Course("计算机", 10.5, 11.5);
    private static final ClassRoom.Course MUSIC = new ClassRoom().new Course("音乐", 11, 12);

    @Tested
    private ClassRoom classRoom;

    @Test
    public void plan() {
        Set<ClassRoom.Course> plan = classRoom.plan(Sets.newHashSet(ART, ENGLISH, MATHEMATICS, COMPUTER, MUSIC));
        Assert.assertEquals(3, plan.size());
        Assert.assertTrue(plan.contains(ART));
        Assert.assertTrue(plan.contains(MATHEMATICS));
        Assert.assertTrue(plan.contains(MUSIC));
    }
}