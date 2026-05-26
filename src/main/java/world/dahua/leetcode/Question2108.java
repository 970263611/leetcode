package world.dahua.leetcode;

public class Question2108 {

    /**
     * num: 2108
     * <p>
     * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
     * <p>
     * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["abc","car","ada","racecar","cool"]
     * 输出："ada"
     * 解释：第一个回文字符串是 "ada" 。
     * 注意，"racecar" 也是回文字符串，但它不是第一个。
     * 示例 2：
     * <p>
     * 输入：words = ["notapalindrome","racecar"]
     * 输出："racecar"
     * 解释：第一个也是唯一一个回文字符串是 "racecar" 。
     * 示例 3：
     * <p>
     * 输入：words = ["def","ghi"]
     * 输出：""
     * 解释：不存在回文字符串，所以返回一个空字符串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] 仅由小写英文字母组成
     */

    static void main() {
        Question2108 question = new Question2108();
        long begin = System.currentTimeMillis();
        System.out.println(question.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public String firstPalindrome(String[] words) {
        String palindrome = "";
        for (String word : words) {
            boolean b = true;
            for (int i = 0, j = word.length() - 1; i < word.length() && j > i; i++, j--) {
                // 用charAt，不要用toCharArray，时间复杂度更低
                if (word.charAt(i) != word.charAt(j)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                palindrome = word;
                break;
            }
        }
        return palindrome;
    }
}
