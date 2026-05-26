package world.dahua.leetcode;

import java.util.Arrays;

public class Question416 {

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
        Question416 question = new Question416();
        long begin = System.currentTimeMillis();
        System.out.println(question.canPartition(new int[]{3, 3, 6, 8, 16, 16, 16, 18, 20}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = nums[j] - nums[i];
        while (j > i + 1) {
            if (sum >= 0) {
                i++;
                sum -= nums[i];
            } else {
                j--;
                sum += nums[j];
            }
        }
        if (sum == 0) {
            return true;
        } else if (sum > 0) {
            return false;
        } else {
            int t = Math.abs(sum) / 2;
            for (int num : nums) {
                if (t == num) {
                    return true;
                }
                t -= num;
                if (t == 0) {
                    return true;
                }
                if (t < 0) {
                    return false;
                }
            }
        }
        return false;
    }
}
