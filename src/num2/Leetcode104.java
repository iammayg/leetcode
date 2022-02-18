package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode104 {


    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = 1 + maxDepth(root.right);
        int left = 1 + maxDepth(root.left);
        return Math.max(right, left);

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
