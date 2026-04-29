package world.dahua.leetcode;

public class Question560 {

    /**
     * num: 560
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * <p>
     * 子数组是数组中元素的连续非空序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */

    static void main() {
        Question560 question = new Question560();
        long begin = System.currentTimeMillis();
        System.out.println(question.subarraySum(new int[]{0, 0}, 0));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int subarraySum(int[] nums, int k) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                size++;
            }
            int count = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j];
                if (count == k) {
                    size++;
                }
            }
        }
        return size;
    }
}
