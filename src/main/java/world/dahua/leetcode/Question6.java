package world.dahua.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Question6 {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */

    static void main() {
        Question6 question = new Question6();
        long begin = System.currentTimeMillis();
        System.out.println(question.threeSum(new int[]{1, 2, 0, 1, 0, 0, 0, 0}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) { //去重
                continue;
            }
            for (int i = k + 1, j = nums.length - 1; j > i; ) {
                if (j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                int total = nums[k] + nums[i] + nums[j];
                if (total == 0) {
                    result.add(List.of(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                } else if (total > 0) {
                    j--;
                } else if (total < 0) {
                    i++;
                }
            }
        }
        return result;
    }
}
