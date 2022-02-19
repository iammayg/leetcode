package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return false;
        }
        return dfs(root.right,root.left);
    }

    static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (right == null && left != null) || left.val != right.val) {
            return false;
        }

        return dfs(right.left, left.right) && dfs(right.right, left.left);

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
