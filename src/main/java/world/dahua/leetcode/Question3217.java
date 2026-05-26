package world.dahua.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question3217 {

    /**
     * num: 3217
     * <p>
     * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入： nums = [1,2,3], head = [1,2,3,4,5]
     * <p>
     * 输出： [4,5]
     * <p>
     * 解释：
     * <p>
     * <p>
     * <p>
     * 移除数值为 1, 2 和 3 的节点。
     * <p>
     * 示例 2：
     * <p>
     * 输入： nums = [1], head = [1,2,1,2,1,2]
     * <p>
     * 输出： [2,2,2]
     * <p>
     * 解释：
     * <p>
     * <p>
     * <p>
     * 移除数值为 1 的节点。
     * <p>
     * 示例 3：
     * <p>
     * 输入： nums = [5], head = [1,2,3,4]
     * <p>
     * 输出： [1,2,3,4]
     * <p>
     * 解释：
     * <p>
     * <p>
     * <p>
     * 链表中不存在值为 5 的节点。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 105
     * nums 中的所有元素都是唯一的。
     * 链表中的节点数在 [1, 105] 的范围内。
     * 1 <= Node.val <= 105
     * 输入保证链表中至少有一个值没有在 nums 中出现过。
     */

    static void main() {
        Question3217 question = new Question3217();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        long begin = System.currentTimeMillis();
        ListNode listNode = question.modifiedList(new int[]{1, 2, 3}, node1);
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode node = new ListNode();
        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        if (head != null) {
            build(head, numSet, null, node);
        }
        return node;
    }

    public void build(ListNode head, Set<Integer> numSet, ListNode parent, ListNode node) {
        if (head == null) {
            if (parent != null) {
                parent.next = null;
            }
            return;
        }
        int val = head.val;
        if (!numSet.contains(val)) {
            node.val = val;
            if (head.next != null) {
                ListNode next = new ListNode();
                node.next = next;
                build(head.next, numSet, node, next);
            }
        } else {
            build(head.next, numSet, parent, node);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}