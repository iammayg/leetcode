package num2;

public class Leetcode114 {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    static TreeNode dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.right != null) {
            dfs(root.right);
        }
        if (root.left != null) {
            TreeNode toAdd = dfs(root.left);
            TreeNode temp = toAdd;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = toAdd;
            root.left=null;
        }
        return root;
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
