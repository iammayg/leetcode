package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;


public class LC94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(root)){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||Objects.nonNull(root)){
            while (Objects.nonNull(root)){
                stack.push(root);
                root=root.left;
            }
            if (!stack.isEmpty()){
                root=stack.pop();
                res.add(root.val);
                root=root.right;
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
        List<Integer> list = inorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

    }


    //    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }

    public void dfs(TreeNode node, List<Integer> res) {
        if (Objects.nonNull(node)) {
            dfs(node.left, res);
            res.add(node.val);

            dfs(node.right, res);

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
