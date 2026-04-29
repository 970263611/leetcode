package world.dahua.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question438 {

    /**
     * num: 438
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */

    static void main() {
        Question438 question = new Question438();
        long begin = System.currentTimeMillis();
        System.out.println(question.findAnagrams("ab", "ba"));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List anagrams = new LinkedList();
        if (s.length() >= p.length()) {
            char[] parentAry = s.toCharArray();
            char[] childAry = p.toCharArray();
            Arrays.sort(childAry);
            String sortP = new String(childAry);
            char[] slide = s.substring(0, p.length()).toCharArray();
            for (int i = 0; i < parentAry.length; i++) {
                if (i != 0) {
                    if (i + p.length() - 1 > parentAry.length - 1) {
                        break;
                    }
                    System.arraycopy(slide, 1, slide, 0, slide.length - 1);
                    slide[slide.length - 1] = parentAry[i + p.length() - 1];
                }
                char[] clone = slide.clone();
                Arrays.sort(clone);
                if (sortP.equals(new String(clone))) {
                    anagrams.add(i);
                }
            }
        }
        return anagrams;
    }
}
