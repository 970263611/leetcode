package world.dahua.leetcode;

public class Question283 {

    /**
     * num: 283
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */

    static void main() {
        Question283 question = new Question283();
        long begin = System.currentTimeMillis();
        question.moveZeroes(new int[]{2, 1});
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j > nums.length - 1) {
                break;
            }
            if (j > i) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    /**
     * 优秀
     */
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }
    }
}
