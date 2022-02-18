package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    static int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = 1 + dfs(root.left);
        }
        if (root.right != null) {
            right = 1 + dfs(root.right);
        }
        return Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
