package num2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-17
 */
public class Leetcode94 {
    static List<Integer> res;

    //==============================================================================================================================
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.right;
            }
            root=stack.pop();
            root=root.left;
        }
        Collections.reverse(res);
        return res;
    }


    //==============================================================================================================================

    /**
     * 前序遍历
     */
    //    public List<Integer> preorderTraversal(TreeNode root) {
    //        Stack<TreeNode> stack = new Stack<>();
    //        res = new ArrayList<>();
    //
    //        while (root != null || !stack.isEmpty()) {
    //            while (root != null) {
    //                res.add(root.val);
    //                stack.push(root);
    //                root = root.left;
    //            }
    //            root = stack.pop();
    //            root = root.right;
    //        }
    //        return res;
    //    }


    //==============================================================================================================================
    /**
     * 中序遍历
     */

    //    public List<Integer> inorderTraversal(TreeNode root) {
    //        res = new ArrayList<>();
    //        if (root == null) {
    //            return res;
    //        }
    //        Stack<TreeNode> stack = new Stack<>();
    //        while (!stack.isEmpty() || root != null) {
    //            while (root != null) {
    //                stack.push(root);
    //                root = root.left;
    //            }
    //            root = stack.pop();
    //            res.add(root.val);
    //            root = root.right;
    //        }
    //        return res;
    //    }

    /**
     * 中序遍历 递归
     */
    //==============================================================================================================================
    //    public List<Integer> inorderTraversal(TreeNode root) {
    //        res = new ArrayList<>();
    //        dfs(root);
    //        return res;
    //    }
    //
    //    static void dfs(TreeNode root) {
    //        if (root == null) {
    //            return;
    //        }
    //        res.add(root.val);
    //        dfs(root.left);
    //        dfs(root.right);
    //
    //    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
