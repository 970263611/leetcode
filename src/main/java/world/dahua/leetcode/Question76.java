package world.dahua.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question76 {

    /**
     * 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
     * <p>
     * 测试用例保证答案唯一。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     * <p>
     * num: 76
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     * <p>
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s 和 t 由英文字母组成
     * <p>
     * <p>
     * 进阶：你能设计一个在 O(m + n) 时间内解决此问题的算法吗？
     */

    static void main() {
        Question76 question = new Question76();
        long begin = System.currentTimeMillis();
        System.out.println(question.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public String minWindow(String s, String t) {
        String res = "";
        if (t.length() > s.length()) {
            return res;
        }
        if (s.contains(t)) {
            return t;
        }
        char[] tAry = t.toCharArray();
        char[] sAry = s.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : tAry) {
            tMap.compute(c, (_, oldVal) -> {
                if (oldVal == null) {
                    return -1;
                } else {
                    return oldVal - 1;
                }
            });
        }
        boolean needChange = true;
        int left = -1, right = -1, j = 0;
        while (true) {
            if (j < sAry.length) {
                char c = sAry[j];
                if (tMap.containsKey(c)) {
                    if (left < 0) {
                        left = j;
                    }
                    tMap.compute(c, (_, v) -> ++v);
                    if (needChange && tMap.values().stream().allMatch(v -> v >= 0)) {
                        needChange = false;
                        int i = left;
                        while (i <= j) {
                            char ci = sAry[i];
                            if (tMap.containsKey(ci)) {
                                if (tMap.values().stream().allMatch(v -> v >= 0)) {
                                    if (res.equals("") || res.length() > j + 1 - i) {
                                        res = new String(Arrays.copyOfRange(sAry, i, j + 1));
                                    }
                                    tMap.compute(ci, (_, v) -> --v);
                                } else {
                                    left = i;
                                    needChange = true;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    if (!needChange && (sAry[left] == c)) {
                        int i = left;
                        while (i <= j) {
                            char ci = sAry[i];
                            if (tMap.containsKey(ci)) {
                                if (tMap.values().stream().allMatch(v -> v >= 0)) {
                                    if (res.length() > j + 1 - i) {
                                        res = new String(Arrays.copyOfRange(sAry, i, j + 1));
                                    }
                                    tMap.compute(ci, (_, v) -> --v);
                                } else {
                                    left = i;
                                    needChange = true;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    right = j;
                }
                j++;
            } else {
                int i = left;
                while (i >= 0 && i < right) {
                    char ci = sAry[i];
                    if (tMap.containsKey(ci)) {
                        if (tMap.values().stream().allMatch(v -> v >= 0)) {
                            if (res.length() > right - i) {
                                res = new String(Arrays.copyOfRange(sAry, i, right + 1));
                            }
                            tMap.compute(ci, (_, v) -> --v);
                        } else {
                            break;
                        }
                    }
                    i++;
                }
                break;
            }
        }
        return res;
    }
}
