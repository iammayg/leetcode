package num2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    static List<List<Integer>> res;
    static boolean[] path;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new boolean[nums.length];
        dfs(nums,0);

        return res;
    }

    static void dfs(int[] nums, int p) {
        if (p == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                if (path[i]) {
                    cur.add(nums[i]);
                }
            }
            res.add(cur);
            return;
        }
        dfs(nums, p + 1);
        path[p] = true;
        dfs(nums, p + 1);
    }
}
