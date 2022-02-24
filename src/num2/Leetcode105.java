package num2;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    static int[] preorder;
    static int[] inorder;
    static Map<Integer, Integer> map;

    public static TreeNode buildTree(int[] pp, int[] ii) {
        preorder = pp;
        inorder = ii;

        map = new HashMap<>();
        for (int i = 0; i < ii.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length-1, 0, preorder.length-1);
    }

    static TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);

        int k = map.get(preorder[pl]);
        root.left = dfs(pl + 1, pl - il + k, il, k - 1);
        root.right = dfs(pl - il + k + 1, pr, k + 1, ir);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public static class TreeNode {
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
