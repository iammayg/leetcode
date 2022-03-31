package num2;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-03-28
 */
public class JZ26 {
    public static boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return helper(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    static boolean helper(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
