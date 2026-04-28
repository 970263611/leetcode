package world.dahua.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Question8 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */

    static void main() {
        Question8 question = new Question8();
        long begin = System.currentTimeMillis();
        System.out.println(question.lengthOfLongestSubstring("aabaab!bb"));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        List<Character> list = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (list.contains(c)) {
                max = Math.max(max, list.size());
                int index = list.indexOf(c);
                list = list.subList(index + 1, list.size());
            }
            list.add(c);
        }
        return Math.max(max, list.size());
    }
}
