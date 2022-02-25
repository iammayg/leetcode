package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-24
 */
public class Leetcode95 {

    public static List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    static List<TreeNode> dfs(int l, int r) {//这里返回值类型选择：不能选择返回单个节点。
        List<TreeNode> res = new ArrayList<>();

        if (l > r) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = dfs(l, i - 1);
            List<TreeNode> right = dfs(i + 1, r);
            for (TreeNode ll : left) {
                for (TreeNode rr : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = ll;
                    root.right = rr;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);
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
