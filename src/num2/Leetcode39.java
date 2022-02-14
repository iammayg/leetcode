package num2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-10
 */
public class Leetcode39 {
    static List<List<Integer>> res;
    static int[] path;

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new int[nums.length];
        dfs(target, nums, 0);
        return res;

    }

    static void dfs(int target, int[] nums, int p) {
        if (target == 0) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < path[i]; j++) {
                    cur.add(nums[i]);
                }
            }
            res.add(cur);
            return;
        }
        for (int i = 0; p < nums.length && target >= nums[p] * i; i++) {
            path[p] = i;
            dfs(target - nums[p] * i, nums, p + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 1};
        combinationSum(nums, 9);
    }
}


