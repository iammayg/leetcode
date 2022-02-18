package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode110 {

    static boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        dfs(root);
        return res;
    }

    static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = 1 + dfs(root.right);
        int left = 1 + dfs(root.left);
        if (Math.abs(right - left) > 1) {
            res = false;
        }
        return Math.max(right,left);
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
