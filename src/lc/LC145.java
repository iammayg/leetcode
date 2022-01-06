package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;



public class LC145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()||Objects.nonNull(root)){
            while (Objects.nonNull(root)){
                res.add(root.val);
                stack.push(root);
                root=root.right;
            }
            if (!stack.isEmpty()){
                root=stack.pop();
                root=root.left;
            }
        }
        Collections.reverse(res);
        return res;
    }

    //    public List<Integer> postorderTraversal(TreeNode root) {
    //        List<Integer> res = new ArrayList<>();
    //        dfs(root, res);
    //        return res;
    //    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (Objects.nonNull(node)) {
            dfs(node.left, res);
            dfs(node.right, res);
            res.add(node.val);

        }

    }

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
