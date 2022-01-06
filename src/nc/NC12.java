package nc;

import java.util.HashMap;
import java.util.Map;


public class NC12 {
    static Map<Integer, Integer> map = new HashMap<>();//key 数组2 的值，value值的下标
    static int[] spre;
    static int[] sin;


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        spre = pre;
        sin = in;

        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return dfs(0, pre.length - 1, 0, pre.length - 1);
    }

    //返回节点
    static TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pr < pl) {
            return null;
        }
        TreeNode root = new TreeNode(spre[pl]);
        int p = map.get(spre[pl]);
        TreeNode left = dfs(pl + 1, pl + p - il, il, p - 1);
        TreeNode right = dfs(pl+p-il+1 , pr, p + 1, ir);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        reConstructBinaryTree(pre, in);
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
