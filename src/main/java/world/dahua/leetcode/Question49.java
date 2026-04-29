package world.dahua.leetcode;

import java.util.*;

public class Question49 {

    /**
     * num: 49
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * <p>
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * 解释：
     * <p>
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 示例 2:
     * <p>
     * 输入: strs = [""]
     * <p>
     * 输出: [[""]]
     * <p>
     * 示例 3:
     * <p>
     * 输入: strs = ["a"]
     * <p>
     * 输出: [["a"]]
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     */

    static void main() {
        Question49 question = new Question49();
        long begin = System.currentTimeMillis();
        System.out.println(question.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    /**
     * 我的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> temp = new ArrayList<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            temp.add(new String(charArray));
        }
        Set<String> set = new HashSet<>(temp);
        Map<String, List<String>> map = new HashMap();
        for (String s : set) {
            map.put(s, new ArrayList<>());
        }
        for (int i = 0; i < temp.size(); i++) {
            String s = temp.get(i);
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    /**
     * 优秀的
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 对每个单词的字母排序，异位词排序后字母都一样
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> words = map.getOrDefault(key, new ArrayList<String>());
            words.add(str);
            map.put(key, words);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
