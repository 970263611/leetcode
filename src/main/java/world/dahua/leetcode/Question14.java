package world.dahua.leetcode;

public class Question14 {

    /**
     * num: 14
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 如果非空，则仅由小写英文字母组成
     */

    static void main() {
        Question14 question = new Question14();
        long begin = System.currentTimeMillis();
        System.out.println(question.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = Character.MIN_VALUE;
            boolean append = true;
            for (String str : strs) {
                if (i == str.length()) {
                    append = false;
                    break;
                }
                char now = str.charAt(i);
                if (c == Character.MIN_VALUE) {
                    c = now;
                } else {
                    if (now != c) {
                        append = false;
                        break;
                    }
                }
            }
            if (append) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
