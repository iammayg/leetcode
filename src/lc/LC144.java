package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LC144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root=stack.pop();
                root = root.right;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        root.left = treeNode;
        root.right = treeNode1;
        treeNode.left = treeNode2;
        List<Integer> list = preorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

    }

    //    public List<Integer> preorderTraversal(TreeNode root) {
    //        List<Integer> res = new ArrayList<>();
    //        dfs(root,res);
    //        return res;
    //    }
    //
    //    public void dfs(TreeNode node, List<Integer> res) {
    //        if (Objects.nonNull(node)) {
    //            res.add(node.val);
    //            dfs(node.left, res);
    //            dfs(node.right, res);
    //        }
    //
    //    }

    static class TreeNode {
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
