package world.dahua.leetcode;

import java.util.*;

public class Question1546_unComplete {

    /**
     * num: 1546
     * <p>
     * 给你一个数组 nums 和一个整数 target 。
     * <p>
     * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,1,1], target = 2
     * 输出：2
     * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
     * 示例 2：
     * <p>
     * 输入：nums = [-1,3,5,1,4,2,-9], target = 6
     * 输出：2
     * 解释：总共有 3 个子数组和为 6 。
     * ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
     * 示例 3：
     * <p>
     * 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
     * 输出：3
     * 示例 4：
     * <p>
     * 输入：nums = [0,0,0], target = 0
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 0 <= target <= 10^6
     */

    static void main() {
        Question1546_unComplete question = new Question1546_unComplete();
        long begin = System.currentTimeMillis();
        System.out.println(question.maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int size = 0;
        NavigableMap<Integer, Integer> index = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j];
                if (count == target) {
                    int finalJ = j;
                    index.compute(i, (_, v) -> v == null ? finalJ : v > finalJ ? finalJ : v);
                    break;
                }
            }
        }
        if (index.size() == 0) {
            return size;
        }
        while (true) {
            Map.Entry<Integer, Integer> first = index.pollFirstEntry();
            int left = first.getKey();
            int right = first.getValue();
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : index.entrySet()) {
                int k = entry.getKey();
                if (k >= left && k <= right) {
                    list.add(k);
                }
            }
            if (list.size() == 1) {

            }
            if (index.isEmpty()) {
                break;
            }
        }
        return size;
    }

    /**
     * 这个题目有歧义，按照测试用例来看应该是连续子数组，但是题目没有表述，如果可以非连续，则用以下的解法
     */
    public int maxNonOverlapping_other(int[] nums, int target) {
        Arrays.sort(nums);
        int size = 0;
        List<Integer> n = new LinkedList<>();
        for (int num : nums) {
            if (num == target) {
                size++;
            } else {
                n.add(num);
            }
        }
        for (int i = 1; i < n.size(); i++) {
            int left = 0;
            while (left < n.size() - i) {
                Set<Integer> removeIndex = new HashSet();
                int index = 0;
                int count = 0;
                while (index < i) {
                    removeIndex.add(index + left);
                    count += n.get(index + left);
                    if (count > target) {
                        left = n.size();
                        break;
                    }
                    index++;
                }
                int j = n.size() - 1;
                while (j > left) {
                    int right = n.get(j);
                    if (count + right > target) {
                        j--;
                        if (j == left) {
                            left++;
                            break;
                        }
                    }
                    if (count + right < target) {
                        left++;
                        break;
                    }
                    if (count + right == target) {
                        removeIndex.add(j);
                        List<Integer> removeValue = removeIndex.stream().map(ri -> n.get(ri.intValue())).toList();
                        for (Integer rv : removeValue) {
                            n.remove(rv);
                        }
                        size++;
                        left = 0;
                        break;
                    }
                }
            }
        }
        return size;
    }
}
