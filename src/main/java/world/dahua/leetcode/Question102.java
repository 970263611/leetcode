package world.dahua.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question102 {

    /**
     * num: 102
     * <p>
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     */
    static void main() {
        Question102 question = new Question102();
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;
        treeNode.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.right = right;
        long begin = System.currentTimeMillis();
        System.out.println(question.levelOrder(treeNode));
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Map<Integer, List<Integer>> result = new TreeMap<>();
        result.put(0, List.of(root.val));
        dfs(root, result, 1);
        return new ArrayList<>(result.values());
    }

    public void dfs(TreeNode root, Map<Integer, List<Integer>> result, int num) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        List<Integer> nodeList = new ArrayList<>();
        if (left != null) {
            nodeList.add(left.val);
        }
        if (right != null) {
            nodeList.add(right.val);
        }
        if (!nodeList.isEmpty()) {
            List<Integer> orDefault = result.getOrDefault(num, new ArrayList<>());
            orDefault.addAll(nodeList);
            result.put(num, orDefault);
        }
        num++;
        dfs(left, result, num);
        dfs(right, result, num);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
