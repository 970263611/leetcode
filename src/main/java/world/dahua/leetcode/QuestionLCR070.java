package world.dahua.leetcode;

public class QuestionLCR070 {

    /**
     * num: LCR070
     * <p>
     * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * 示例 2：
     * <p>
     * 输入: nums =  [3,3,7,7,10,11,11]
     * 输出: 10
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 105
     * <p>
     * <p>
     * 进阶：采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
     * <p>
     * <p>
     * <p>
     * 注意：本题与主站 540 题相同：https://leetcode.cn/problems/single-element-in-a-sorted-array/
     */
    static void main() {
        QuestionLCR070 question = new QuestionLCR070();
        long begin = System.currentTimeMillis();
        System.out.println(question.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    int num;

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        dfs(nums, 0, nums.length - 1);
        return num;
    }

    public void dfs(int[] nums, int from, int end) {
        int mid = (end - from) / 2 + from;
        if (mid > 0 && mid < nums.length - 1 && mid > from && mid < end) {
            num = check(nums, mid);
            if (num >= 0) {
                return;
            }
            if (num < 0 && from < mid) {
                dfs(nums, from, mid);
            }
            if (num < 0 && mid < end) {
                dfs(nums, mid, end);
            }
        }
    }

    public int check(int[] nums, int mid) {
        int a = nums[mid - 1];
        int b = nums[mid];
        int c = nums[mid + 1];
        if (a != b && b != c) {
            return b;
        } else {
            return -1;
        }
    }
}
