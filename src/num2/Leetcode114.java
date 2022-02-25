package num2;

public class Leetcode114 {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    static void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            
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
