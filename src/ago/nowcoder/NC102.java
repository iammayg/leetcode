package ago.nowcoder;

import java.util.Objects;


public class NC102 {
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        boolean lefto1 = dfs(root.left, o1);
        boolean righto2 = dfs(root.right, o2);
        if ((lefto1 && righto2) || (dfs(root.left, o2) && dfs(root.right, o1))) {
            return root.val;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        if (lefto1) {
            return lowestCommonAncestor(root.left, o1, o2);
        } else {
            return lowestCommonAncestor(root.right, o1, o2);
        }
    }

    //返回当前树是否有节点num
    static boolean dfs(TreeNode root, int num) {
        if (Objects.isNull(root)) {
            return false;
        }
        if (root.val == num) {
            return true;
        }
        return dfs(root.left, num) || dfs(root.right, num);
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
