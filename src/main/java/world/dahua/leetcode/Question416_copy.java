package world.dahua.leetcode;

import java.util.Arrays;

public class Question416_copy {

    /**
     * num: 416
     * <p>
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */
    static void main() {
        Question416_copy question = new Question416_copy();
        long begin = System.currentTimeMillis();
        System.out.println(question.canPartition(new int[]{3, 3, 6, 8, 16, 16, 16, 18, 20}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    /**
     * 抄的 01背包问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        // 如果总和是奇数，直接返回false
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        // dp[j]表示能否凑出和为j的子集
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 空集的和为0
        for (int num : nums) {
            // 从target倒序遍历到当前数字num
            for (int j = target; j >= num; j--) {
                // 状态转移：当前数字可选可不选
                dp[j] = dp[j] || dp[j - num];
                // 剪枝优化：如果已经找到解，直接返回
                if (dp[target]) {
                    return true;
                }
            }
        }
        return dp[target];
    }
}
