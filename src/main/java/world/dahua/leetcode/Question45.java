package world.dahua.leetcode;

public class Question45 {

    /**
     * num: 45
     * <p>
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
     * <p>
     * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
     * <p>
     * 0 <= j <= nums[i] 且
     * i + j < n
     * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 n - 1
     */
    static void main() {
        Question45 question = new Question45();
        long begin = System.currentTimeMillis();
        System.out.println(question.jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            if (i + nums[i] >= nums.length - 1) {
                if (nums[i] == 0) {
                    return 0;
                }
                break;
            }
            int index = 0;
            int j = i + 1;
            int max = 0;
            while (j <= i + num && j < nums.length) {
                if (max <= nums[j] + j) {
                    index = j;
                    max = nums[j] + j;
                }
                j++;
            }
            i = index;
            count++;
        }
        return count;
    }
}
