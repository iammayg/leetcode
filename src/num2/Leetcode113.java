package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-18
 */
public class Leetcode113 {
    static List<List<Integer>> res;
    static int[] path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new int[10010];
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        path[0] = root.val;
        dfs(root, targetSum - root.val, 1);
        return res;
    }

    static void dfs(TreeNode root, int n, int p) {

        if (root.left == null && root.right == null) {
            if (n == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < p; i++) {
                    list.add(path[i]);
                }
                res.add(list);
            }

            return;
        }


        if (root.left != null) {
            path[p] = root.left.val;
            dfs(root.left, n - root.left.val, p + 1);
        }
        if (root.right != null) {
            path[p] = root.right.val;
            dfs(root.right, n - root.right.val, p + 1);
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
