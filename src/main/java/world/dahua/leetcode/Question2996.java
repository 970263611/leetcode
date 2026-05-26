package world.dahua.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question2996 {

    /**
     * num: 2996
     * <p>
     * 给你一个下标从 0 开始的整数数组 nums 。
     * <p>
     * 如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。
     * <p>
     * 请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,2,5]
     * 输出：6
     * 解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,5,1,12,14,13]
     * 输出：15
     * 解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最小整数。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50
     * 1 <= nums[i] <= 50
     */

    /**
     * 这个题题意模糊，无意义
     */
    static void main() {
        Question2996 question = new Question2996();
        long begin = System.currentTimeMillis();
        System.out.println(question.missingInteger(new int[]{37, 1, 2, 9, 5, 8, 5, 2, 9, 4}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int missingInteger(int[] nums) {
        Set numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                max += nums[i];
            } else {
                break;
            }
        }
        while (numSet.contains(max)) {
            max++;
        }
        return max;
    }
}
