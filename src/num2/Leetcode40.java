package num2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mayonggang <mayonggang03@kuaishou.com>
 * Created on 2022-02-11
 * dfs
 */
public class Leetcode40 {
    static int[] path;
    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        path = new int[100];
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(target, nums, 0, 0);
        return res;
    }

    static void dfs(int target, int[] nums, int pn, int pp) {
        if (pn >= nums.length) {
            if (target == 0) {
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < pp; i++) {
                    cur.add(path[i]);
                }
                res.add(cur);
            }
            return;
        }

        /**
         * 重复元素问题，这里才用的方法是排序让重复的元素挨在一起，选择完重复元素后将重复元素跳过去
         * jz38也有这个问题，但是那个题需要所有元素都选择一遍，所以用了给重复元素定义一个序的解法
         */
        int count = 0;
        while (count + pn < nums.length && nums[pn] == nums[count + pn]) {
            count++;
        }
        for (int i = 0; target >= nums[pn] * i && i <= count; i++) {
            for (int j = 1; j <= i; j++) {
                path[pp + j - 1] = nums[pn];
            }
            dfs(target - nums[pn] * i, nums, pn + count, pp + i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,1,2,7,6,1,5};
        combinationSum2(nums, 8);
    }
}
