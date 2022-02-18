package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode124 {
    static int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    /**
     * 函数返回以root 为最顶部点的 左边或者右边 路径的最大值
     */
    static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int v = root.val;
        int vl = Math.max(0, dfs(root.left));

        int vr = Math.max(0, dfs(root.right));
        int sum = v + Math.max(vl, vr);
        res = Math.max(res, sum + vl + vr);//更新的时候可以以root为跟节点将左边和右边同时走一遍
        return sum;
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
