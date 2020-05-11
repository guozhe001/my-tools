package com.leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class P3LongestSubstringWithoutRepeatingCharactersTest {

    P3LongestSubstringWithoutRepeatingCharacters.Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();

    @Test
    public void lengthOfLongestSubstring() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, maxUnRepeatLength);
    }

    @Test(expected = NullPointerException.class)
    public void lengthOfLongestSubstring0() {
        solution.lengthOfLongestSubstring(null);
    }

    @Test
    public void lengthOfLongestSubstring1() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("");
        Assert.assertEquals(0, maxUnRepeatLength);
    }

    @Test
    public void lengthOfLongestSubstring2() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, maxUnRepeatLength);
    }

    @Test
    public void lengthOfLongestSubstring3() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, maxUnRepeatLength);
    }

    @Test
    public void lengthOfLongestSubstring4() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("au");
        Assert.assertEquals(2, maxUnRepeatLength);
    }

    @Test
    public void lengthOfLongestSubstring5() {
        int maxUnRepeatLength = solution.lengthOfLongestSubstring("a");
        Assert.assertEquals(1, maxUnRepeatLength);
    }

    @Test
    public void getUnRepeatMap() {
        Map<Integer, Integer> unRepeatMap = solution.getUnRepeatMap("abcabcbb".toCharArray());
        unRepeatMap.forEach((k, v) -> {
            log.info("k={}", k);
        });
    }

}