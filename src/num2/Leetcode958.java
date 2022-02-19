package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode958 {
    static boolean[] st = new boolean[100010];
    static int n;

    public boolean isCompleteTree(TreeNode root) {
        n = 0;
        dfs(root);
        for (int i = 1; i <= n; i++) {
            if (!st[i]){
                return false;
            }
        }
        return true;
    }

    static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        n = Math.max(n, root.val);
        st[root.val] = true;
        dfs(root.left);
        dfs(root.right);
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
