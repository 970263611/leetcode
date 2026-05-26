package world.dahua.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question239 {

    /**
     * num: 239
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回 滑动窗口中的最大值 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * <p>
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */

    static void main() {
        Question239 question = new Question239();
        int[] ex = new int[]{41, 8467, 6334, 6500, 9169, 5724};
        int k = 3;
        long begin = System.currentTimeMillis();
        int[] ints = question.maxSlidingWindow(ex, k);
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
        begin = System.currentTimeMillis();
        int[] intsOld = question.maxSlidingWindowOld(ex, k);
        System.out.println("Old Cost: " + (System.currentTimeMillis() - begin) + "ms");
        Arrays.stream(ints).forEach(System.out::println);
        System.out.println("---");
        Arrays.stream(intsOld).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        max[0] = deque.getFirst();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.getFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            max[i - k + 1] = deque.getFirst();
        }
        return max;
    }

    public int[] maxSlidingWindowOld_1(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int size = nums.length - k + 1;
        int[] max = new int[nums.length - 1];
        while (true) {
            for (int i = 0, j = nums.length - 1; j >= i; i++, j--) {
                max[i] = Math.max(nums[i], nums[i + 1]);
                if (i != j) {
                    max[max.length - 1 - i] = Math.max(nums[j], nums[j - 1]);
                }
            }
            if (size != max.length) {
                nums = max;
                max = new int[nums.length - 1];
            } else {
                break;
            }
        }
        return max;
    }

    public int[] maxSlidingWindowOld(int[] nums, int k) {
        List<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length) {
                break;
            }
            if (nums[i + k - 1] < max) {
                for (int j = i; j < i + k; j++) {
                    max = Math.max(max, nums[j]);
                }
            }
            maxList.add(max);
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
