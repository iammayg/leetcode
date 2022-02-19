package num2;


/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);

    }

    static boolean dfs(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            return n == root.val;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = dfs(root.left, n - root.val);
        }
        if (root.right != null) {
            right = dfs(root.right, n - root.val);
        }
        return left || right;
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
