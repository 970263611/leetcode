package world.dahua.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Question128 {

    /**
     * num: 128
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * 示例 3：
     * <p>
     * 输入：nums = [1,0,1,2]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */

    static void main() {
        Question128 question = new Question128();
        long begin = System.currentTimeMillis();
        System.out.println(question.longestConsecutive(new int[]{1, 0, 1, 2}));
//        System.out.println(question.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new LinkedHashSet(Arrays.stream(nums).boxed().sorted().collect(Collectors.toList()));
        int count = 1;
        Iterator<Integer> iterator = set.iterator();
        int begin = iterator.next();
        iterator.remove();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == begin + 1) {
                begin = next;
                count++;
            } else {
                begin = next;
                result.add(count);
                count = 1;
            }
        }
        result.add(count);
        return result.isEmpty() ? 0 : result.stream().max(Integer::compareTo).get();
    }

    /**
     * 优秀
     */
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 0;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;   //跳过相同的元素
            } else if (nums[i] == nums[i - 1] + 1) {
                //连续的元素
                tmp++;
            } else {
                //连续中断
                ans = Math.max(ans, tmp);
                tmp = 1;
            }
        }
        return Math.max(ans, tmp);
    }
}
