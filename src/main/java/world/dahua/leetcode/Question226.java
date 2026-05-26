package world.dahua.leetcode;

public class Question226 {

    /**
     * num: 226
     * <p>
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中节点数目范围在 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    static void main() {
        Question226 question = new Question226();
        long begin = System.currentTimeMillis();
        question.invertTree(null);
        System.out.println("Cost: " + (System.currentTimeMillis() - begin) + "ms");
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return root;
    }

    public void dfs(TreeNode root) {
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        if (r != null) {
            dfs(r);
        }
        if (l != null) {
            dfs(l);
        }
    }

    public class TreeNode {
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
