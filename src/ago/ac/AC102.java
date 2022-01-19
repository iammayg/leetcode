package ago.ac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;


public class AC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>>res=new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> curList=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curList.add(cur.val);
                if (Objects.nonNull(cur.left)){
                    queue.add(cur.left);
                }
                if (Objects.nonNull(cur.right)){
                    queue.add(cur.right);
                }
            }
            res.add(curList);

        }
        return res;
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
