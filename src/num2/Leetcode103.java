package num2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-17
 *
 * 二叉树
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag;
        queue.add(root);

        flag = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] treeNodes = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                treeNodes[i] = cur;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            List<Integer> list = new ArrayList<>();
            if (flag) {
                for (int i = 0; i < size; i++) {
                    list.add(treeNodes[i].val);
                }
            } else {
                for (int i = size - 1; i >= 0; i --) {
                    list.add(treeNodes[i].val);
                }
            }
            res.add(list);
            flag = !flag;

        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
