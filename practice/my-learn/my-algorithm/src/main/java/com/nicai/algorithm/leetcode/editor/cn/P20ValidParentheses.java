package com.nicai.algorithm.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3521 👎 0

import java.util.*;

public class P20ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Map<String, String> pair = pair();
            Stack<String> strings = new Stack<>();
            for (char c : s.toCharArray()) {
                String sub = String.valueOf(c);
                if (strings.isEmpty()) {
                    strings.push(sub);
                } else {
                    if (pair.containsKey(sub)) {
                        if (Objects.equals(pair.get(sub), strings.peek())) {
                            strings.pop();
                        }
                    } else {
                        strings.push(sub);
                    }
                }
            }
            return strings.isEmpty();
        }

        private Map<String, String> pair() {
            HashMap<String, String> map = new HashMap<>();
            map.put("(", ")");
            map.put("{", "}");
            map.put("[", "]");
            return map;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}