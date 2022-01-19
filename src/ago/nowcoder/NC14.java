package ago.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class NC14 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (Objects.isNull(root)) {
            return res;
        }
        boolean flag=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> curList=new ArrayList<>();
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
            if (flag){
                Collections.reverse(curList);
            }
            res.add(curList);

            flag=!flag;
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
